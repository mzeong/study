> error: ER_NOT_SUPPORTED_AUTH_MODE: Client does not support authentication protocol requested by server; consider upgrading MySQL client

`npm i mysql`로 설치한 `mysqljs` 패키지가 MYSQL 8에서 새로 도입한 인증 방법인 `caching_sha2_password`를 지원하지 않아 발생한 문제이다. 

<br>

#### 방법 1) [권장하지 않음]

```
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password ...
```

MySQL을 다운그레이드해서 오래된 `mysql_native_password`를 사용해 인증한다.

#### 방법 2) [권장]

```
npm un mysql && npm i mysql2
```

<br>

### 참고

https://stackoverflow.com/questions/50093144/mysql-8-0-client-does-not-support-authentication-protocol-requested-by-server
