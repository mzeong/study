<h3>라우팅 분리</h3>

라우터를 많이 연결하면 `app.js` 코드가 매우 길어지므로 익스프레스에서는 라우터를 분리할 수 있는 방법을 제공한다.

`routes` 폴더를 만들고 그 안에 라우터 파일을 작성한다. 

```
// routes/index.js
const express = require('express');
const router = express.Router();

// GET / 라우터
router.get('/', (req, res) => {
  res.send('Hello, Express');
});

module.exports = router;
```

```
// routes/user.js
...
// GET /user 라우터
router.get('/', (req, res) => {
  res.send('Hello, User');
});
...
```

이렇게 만들어진 파일을 `app.use`를 통해 `app.js`에 연결한다.

```
const indexRouter = require('./routes');
const userRouter = require('./routes/user');

app.use('/', indexRouter);
app.use('/user', userRouter);
```

- `index.js`는 생략할 수 있어서 `./routes/index.js`와 `./routes`는 같다.
- `app.use`로 연결할 때 <u>주소가 합쳐진다.</u> `indexRouter`는 `use`의 `'/'`와 `get`의 `'/'`가 합쳐져 GET / 라우터가 되고, `userRouter`는 `use`의 `'/user'`와 `get`의 `'/'`가 합쳐져 GET /user 라우터가 된다.

<br>
<h3>next('route')</h3>

`next('route')`로 라우터에 연결된 나머지 미들웨어들을 건너뛰고 다음 라우터로 넘어갈 수 있다. 

```
router.get('/', (req, res, next) => {
  next('route');
}, (req, res, next) => {
  console.log('실행되지 않습니다');
  next();
}, (req, res, next) => {
  console.log('실행되지 않습니다');
  next();
});
router.get('/', (req, res) => {
  console.log('실행됩니다');
  res.send('Hello, Express');
});
```

<br>
<h3>라우트 매개변수</h3>

다양한 라우터를 아우르는 와일드카드 역할을 하므로 일반 라우터보다는 뒤에 위치해야 한다. 

```
router.get('/user/:id', (req, res) => {
  console.log(req.params, req.query);
});
```

- `:id`이면 `req.params.id`로 조회할 수 있다.

<br>
<h3>404 응답 미들웨어</h3>

에러 처리 미들웨어 위에 넣어둔 미들웨어는 일치하는 라우터가 없을 때 404 상태 코드를 응답하는 역할을 한다.

```
app.use((req, res, next) => {
  res.status(404).send("Not Found");
});
```
- 이 미들웨어를 제거하고 localhost:3000/abc에 접속하면 404 상태 코드와 함께 Cannot GET /abc 메시지가 응답된다. 

<br>
<h3>라우터 그룹화</h3>

주소는 같지만 메서드가 다른 코드가 있을 때

```
router.get('/abc', (req, res) => {
  res.send('GET /abc');
});
router.post('/abc', (req, res) => {
  res.send('POST /abc');
});
```

`router.route`로 묶을 수 있다.

```
router.route('/abc')
  .get((req, res) => {
    res.send('GET /abc');
  })
  .post((req, res) => {
    res.send('POST /abc');
});
```

<br>
<h3>참고</h3>

Node.js 교과서 - 기본부터 프로젝트 실습까지
