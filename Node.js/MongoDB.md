### MongoDB

#### MongoDB 실행 

```
cd C:\Program Files\MongoDB\Server\6.0\bin
mongod --ipv6 --auth
```

#### Mongoose ODM 설치
```
npm i mongoose
```

#### 몽구스를 통해 몽고디비 연결하기 

```javascript
//schemas/index.js
const mongoose = require('mongoose');

const connect = () => {
  if (process.env.NODE_ENV !== 'production') {
    mongoose.set('debug', true);
  }
  mongoose
    .connect('mongodb://root:password@localhost:27017/admin', {
      dbName: 'dbName',
      useNewUrlParser: true,
    })
    .then(() => {
      console.log('몽고디비 연결 성공');
    })
    .catch((err) => {
      console.error('몽고디비 연결 에러', err);
    });
};

mongoose.connection.on('error', (error) => {
  console.error('몽고디비 연결 에러', error);
});
mongoose.connection.on('disconnected', () => {
  console.error('몽고디비 연결이 끊겼습니다. 연결을 재시도합니다.');
  connect();
});

module.exports = connect;
```

#### 앱과 연결하기

```javascript
//app.js
const connect = require('./schemas');
...
connect();
```

<br>

### 참고

Node.js 교과서 - 기본부터 프로젝트 실습까지
