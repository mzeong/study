### JWT (JSON Web Token)

헤더.페이로드.시그니처로 구성된다. 
- 헤더: 토큰 종류와 해시 알고리즘 정보가 들어있다.
- 페이로드: 토큰의 내용물이 인코딩된 부분이다. 
- 시그니처: 일련의 문자열로, 시그니처를 통해 토큰이 변조되었는지 여부를 확인한다. 시그니처는 JWT 비밀키로 만들어지고, 비밀키가 노출되면 토큰 위조가 가능하다. 

페이로드 내용을 볼 수 있기 때문에 JWT에 민감한 내용을 넣으면 안 된다.
-  그럼에도 사용하는 이유는 토큰 변조가 불가능하고, 내용물이 들어있기 때문(DB 조회를 하지 않을 수 있음)이다.
- 용량이 커서 요청 시 데이터 양이 증가한다는 단점이 있다.  

<br>

1. JWT 모듈 설치 

```
npm i jsonwebtoken
```

2. JWT 비밀키 .env에 저장

3. `jwt.verify` 메서드로 검사

- `req.decoded`에 페이로드를 넣어 다음 미들웨어에서 쓸 수 있게 한다. 

```javascript
const jwt = require('jsonwebtoken');

exports.verifyToken = (req, res, next) => {
	try {
		req.decoded = jwt.verify(req.headers.authorization, process.env.JWT_SECRET);
		return next();
	} catch (error) {
		if (error.name === 'TokenExpiredError') {
			return res.status(419).json({
				code: 419,
				message: '토큰이 만료되었습니다.',
			});
		}
		return res.status(401).json({
			code: 401,
			message: '유효하지 않은 토큰입니다.',
		});
	}
};
```

4. `jwt.sign` 메서드로 토큰 발급 

- 첫 번째 인수로 페이로드, 두 번째 인수로 JWT 비밀키, 세 번째 인수로 토큰 옵션을 넣는다. 

```javascript
const token = jwt.sign({
	id: domain.user.id,
	nick: domain.user.nick,
}, process.env.JWT_SECRET, {
	expiresIn: '1m',
	issuer: 'nodebird',
});
```

<br>

### 참고 

Node.js 교과서 - 기본부터 프로젝트 실습까지
