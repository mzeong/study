<h3>dotenv</h3>

설치하고

```
npm i dotenv
```

프로젝트의 루트에 `.env` 파일을 생성한다. 세미콜론 없이 `키=값` 형태로 적는다.

```
COOKIE_SECRET=1234
DB_PASSWORD=abcd
```

가능한 파일 상단에 작성하는 것이 좋다.

```
const dotenv = require("dotenv");
dotenv.config();
```

이제 소스코드에 값이 노출되지 않는다.

```
app.use(cookieParser(process.env.COOKIE_SECRET));
```

<br>
<h3>참고</h3>

Node.js 교과서 - 기본부터 프로젝트 실습까지
