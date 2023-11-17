### 패스포트 설치

로그인 과정을 쉽게 처리할 수 있게 도와주는 `passport`를 설치한다. 
비밀번호 암호화를 위한 `bcrypt`도 같이 설치한다. 

```
npm i passport passport-local passport-kakao bcrypt
```

```javascript 
//app.js
...
const passport = require('passport');
...
const passportConfig = require('./passport');
...
passportConfig(); //패스포트 설정
...
app.use(session({ ... }));
app.use(passport.initialize()); //요청 객체에 passport 설정을 심음
app.use(passport.session()); //req.session 객체에 passport 정보를 저장
```

<br>

### 패스포트 모듈 작성

```javascript
//passport/index.js
const passport = require('passport');
const local = require('./localStrategy');
const kakao = require('./kakaoStrategy');
const User = require('../models/user');

module.exports = () => {
    passport.serializeUser((user, done) => { //req.session 객체에 어떤 데이터를 저장할 지 선택
        done(null, user.id); //메모리를 적게 차지하기 위해 사용자 정보 중 아이디만 저장 
    });
    passport.deserializeUser((id, done) => { //req.session에 저장된 id 바탕으로 DB 조회 후 req.user에 저장 
        User.findOne({ where: { id } })
            .then((user) => done(null, user))
            .catch((err) => done(err));
    });

    local();
    kakao();
};
```

<br>

### 패스포트 처리 과정 

#### 로그인 과정 

1. 로그인 요청이 들어옴 
2. `passport.authenticate` 메서드 호출 
3. 로그인 전략 수행 
4. 로그인 성공 시 사용자 정보 객체와 함께 `req.login` 호출
5. `req.login` 메서드가 `passport.serializeUser` 호출
6. `req.session`에 사용자 아이디만 저장 
7. 로그인 완료 

```javascript
//routes/auth.js
router.post('/login', isNotLoggedIn, login);
```

```javascript
//controllers/auth.js
exports.login = (req, res, next) => {
    passport.authenticate('local', (authError, user, info) => {
        if (authError) { //서버 실패
            console.error(authError);
            return next(authError);
        }
        if (!user) { //로직 실패
            return res.redirect('/?loginError=${info.message}');
        }
        return req.login(user, (loginError) => { //로그인 성공
            if (loginError) {
                console.error(loginError);
                return next(loginError);
            }
            return res.redirect('/');
        });
    })(req, res, next);
};
```

```javascript
//passport/localStrategy.js
const { Strategy: localStrategy } = require('passport-local');

module.exports = () => {
    passport.use(
        new localStrategy(
            {
                usernameField: 'email', //req.body.email
                passwordField: 'password', //req.body.password
                passReqToCallback: false, //true로 하면 async(req, email, password, done)
            },
            async (email, password, done) => { //done(서버실패, 성공유저, 로직실패)
                try {
                    const exUser = await User.findOne({ where: { email } });
                    if (exUser) {
                        const result = await bcrypt.compare(password, exUser.password);
                        if (result) {
                            done(null, exUser);
                        } else {
                            done(null, false, { message: '비밀번호가 일치하지 않습니다.' });
                        }
                    } else {
                        done(null, false, { message: '가입되지 않은 회원입니다.' });
                    }
                } catch (error) {
                    console.error(error);
                    done(error);
                }
            }
        )
    );
};
```

<br>

#### 로그인 이후 과정

1. 모든 요청에 `passport.session()` 미들웨어가 `passport.deserializeUser` 메서드 호출
2. `req.session`에 저장된 아이디로 데이터베이스에서 사용자 조회
3. 조회된 사용자 정보를 `req.user`에 저장
4. 라우터에서 `req.user` 객체 사용 가능  

<br>

### 카카오 로그인 구현 

```javascript
//routes/auth.js
router.get('/kakao', passport.authenticate('kakao'));
router.get(
    '/kakao/callback',
    passport.authenticate('kakao', {
        failureRedirect: '/?loginError=카카오로그인 실패',
    }),
    (req, res) => {
        res.redirect('/');
    }
);
```

```javascript
const { Strategy: KakaoStrategy } = require('passport-kakao');

module.exports = () => {
    passport.use(
        new KakaoStrategy(
            {
                clientID: process.env.KAKAO_ID,
                callbackURL: '/auth/kakao/callback',
            },
            async (accessToken, refreshToken, profile, done) => {
                try {
                    console.log('kakao profile', profile);
                    const exUser = await User.findOne({
                        where: { snsId: profile.id, provider: 'kakao' },
                    });
                    if (exUser) {
                        done(null, exUser);
                    } else {
                        const newUser = await User.create({
                            email: profile._json?.kakao_account?.email,
                            nick: profile.displayName,
                            snsId: profile.id,
                            provider: 'kakao',
                        });
                        done(null, newUser);
                    }
                } catch (error) {
                    console.error(error);
                    done(error);
                }
            }
        )
    );
};
```

- https://developers.kakao.com 에서 `REST API 키`를 가져온다. 
- Web 플랫폼 등록한 후 Redirect URI를 `http://localhost:8001/auth/kakao/callback`으로 등록한다. 

<br>

### 참고
 
 Node.js 교과서 - 기본부터 프로젝트 실습까지
