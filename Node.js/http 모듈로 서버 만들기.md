### HTTP 서버 만들기

`createServer`로 요청 이벤트에 대기한다. `res` 메서드로 응답을 보낸다. <br>
`listen` 메서드로 특정 포트에 연결한다. (`localhost:8080` 또는 `http://127.0.0.1:8080`에 접속) <br>
한 번에 여러 개의 서버를 실행하고 싶다면, `createServer`를 여러 번 호출하면 된다. (단, 서버의 포트 다르게 해서)

```javascript
const http = require("http");

const server = http.createServer((req, res) => {
  res.writeHead(200, { "Content-Type": "text/html; charset=utf-8" });
  res.write("<h1>Hello Node!</h1>");
  res.end("<p>how are you?</p>");
});
server.listen(8080);

server.on("listening", () => {
  console.log("8080번 포트에서 서버 대기 중입니다.");
});
server.on("error", (error) => {
  console.log(error);
});
```

`fs`로 html 파일 읽어서 제공하면 더 편하다. 

```javascript
const fs = require("fs").promises;

const server = http.createServer(async (req, res) => {
  try {
    const data = await fs.readFile("./3-2.html");
    res.end(data);
  } 
  ...
```

<br>

### REST API

- 서버에 요청을 보낼 때는 주소를 통해 요청의 내용을 표현
- REST API는 서버의 자원을 정의하고 자원에 대한 주소를 지정하는 방법 (일종의 주소 정하는 규칙)
- REST API를 사용한 주소 체계를 이용하는 서버를 RESTful한 서버라고 한다.

#### HTTP 요청 메서드

1. GET: 서버 자원을 가져오려고 할 때 사용
2. POST: 서버에 자원을 새로 등록하고자 할 때 사용 (또는 뭘 써야할 지 애매할 때 - 예. 돈 보내라, 로그인 해라)
3. PUT: 서버의 자원을 요청에 들어있는 자원으로 치환하고자 할 때 사용 (전체수정)
4. PATCH: 서버 자원의 일부만 수정하고자 할 때 사용 (부분수정)
5. DELETE: 서버의 자원을 삭제하고자 할 때 사용

> HTTP response status codes ([링크](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status))

<br>

### 쿠키

- 서버는 <ins>누가</ins> 요청을 보냈는지 모르니까 로그인을 구현해서 알아내야 한다. (쿠키와 세션이 필요)
- 쿠키는 키=값의 쌍
- 서버로부터 쿠키가 오면, 웹 브라우저는 저장해뒀다가 다음 요청마다 쿠키를 동봉해서 보냄 & 서버는 요청 속 쿠키를 읽어 사용자 파악
- `writeHead` 메서드에 `Set-Cookie`로 쿠키 넣는 것을 직접 구현할 수 있다.

<br>

### 세션

- 쿠키의 정보는 노출되고 수정되는 위험이 있다.
- 중요한 정보는 서버에서 관리하고 클라이언트에는 세션 키만 제공한다. 
- 서버에 세션 객체 생성 후, uniqueInt(키)를 만들어 속성명으로 사용 & 속성 값에 정보 저장하고 uniqueInt를 클라이언트에 보냄

<br>

### https

- 오고 가는 데이터를 암호화해서 중간에 다른 사람이 요청을 가로채더라도 내용을 확인할 수 없다. 
- 요즘에는 https 적용이 필수 (개인 정보가 있는 곳은 특히)
- `createServer`가 인자를 두 개 받는다. (첫 번째 인자는 인증서와 관련된 옵션 객체, 두 번째 인자는 서버 로직)
- 443번 포트 사용

<br>

### http2

- SSL 암호화와 더불어 최신 HTTP 프로토콜인 http/2를 사용하는 모듈
- 요청 및 응답 방식이 기존 http/1.1보다 개선됐다. (자원을 동시에)
- 웹의 속도도 개선됐다.
- `https` 모듈을 `http2`로, `createServer` 메서드를 `createSecureServer` 메서드로 바꾸면 된다. 

<br>

### cluster

- 기본적으로 싱글 스레드인 노드가 CPU 코어를 모두 사용할 수 있게 해주는 모듈
- <ins>포트를 공유하는</ins> 노드 프로세스를 여러 개 둘 수 있다.
- 코어가 8개인 서버가 있을 때 보통은 코어 하나만 활용, cluster로 코어 하나당 노드 <ins>프로세스</ins> 하나를 배정 가능 (성능이 8배가 되는 것은 아니지만 개선됨)
- 단점: 컴퓨터 자원(메모리, 세션 등) 공유 못 함 (Radis 등 별도 서버로 해결)

<br>

### 참고

Node.js 교과서 - 기본부터 프로젝트 실습까지
