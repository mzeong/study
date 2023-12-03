### 사용량 제한 구현하기

일정 시간 동안 횟수 제한을 두어 무차별적인 요청을 막을 필요가 있다. 

```
npm i express-rate-limit
```

```javascript
const rateLimit = require('express-rate-limit');
...
exports.apiLimiter = rateLimit({
    windowMs: 60 * 1000, //1분
    max: 10,
    handler(req, res) {
        res.status(this.statusCode).json({
            code: this.statusCode,
            message: '1분에 열 번만 요청할 수 있습니다.',
        });
    },
});
```
- `windowMS`: 기준 시간, `max`: 허용 횟수, `handler`: 제한 초과 시 콜백 함수

<br>

### 새 라우터 버전 내놓기 

더는 사용하면 안 되는 라우터에 deprecated 미들웨어를 붙여서 사용 시 경고한다. 

```javascript
//middlewares/index.js
exports.deprecated = (req, res) => {
    res.status(410).json({
        code: 410,
        message: '새로운 버전이 나왔습니다. 새로운 버전을 사용하세요.',
    });
};
```

`router.use`로 한 번에 모든 라우터에 적용하면 된다. 

```javascript
//routes/v1.js
const express = require('express');

const { verifyToken, deprecated } = require('../middlewares');
const { createToken, tokenTest, getMyPosts, getPostsByHashtag } = require('../controllers/v1');

const router = express.Router();

router.use(deprecated);

router.post('/token', createToken);
router.get('/test', verifyToken, tokenTest);

router.get('/posts/my', verifyToken, getMyPosts);
router.get('/posts/hashtag/:title', verifyToken, getPostsByHashtag);

module.exports = router;
```

<br>

### 참고

Node.js 교과서 - 기본부터 프로젝트 실습까지
