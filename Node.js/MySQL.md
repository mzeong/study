### MySQL

#### Sequelize ORM 사용  

```
npm i sequelize sequelize-cli mysql2
```
- 시퀄라이즈 명령어를 사용하기 위해 `sequelize-cli`를 설치한다.
- `mysql2`는 MySQL DB가 아니라 Node.js와 MySQL을 이어주는 역할을 하는 드라이버이다.  

```
npx sequelize init
```
- 시퀄라이즈 폴더 구조 생성

```javascript
//config/config.json
{
  "development": {
    "username": "root",
    "password": "패스워드입력",
    "database": "데이터베이스입력",
```

```javascript
//models/index.js
const Sequelize = require('sequelize');

const env = process.env.NODE_ENV || 'development';
const config = require('../config/config')[env];
const db = {};

const sequelize = new Sequelize(config.database, config.username, config.password, config);

db.sequelize = sequelize;

module.exports = db;
```

```javascript
//app.js
const { sequelize } = require('./models');
...
sequelize
  .sync({ force: false })
  .then(() => {
    console.log('데이터베이스 연결 성공');
  })
  .catch((err) => {
    console.error(err);
  });
```

<br>

#### MySQL 접속 

```
C:\Program Files\MySQL\MySQL Server 8.0\bin
mysql -h localhost -u root -p
```


<br>

### 참고

Node.js 교과서 - 기본부터 프로젝트 실습까지
