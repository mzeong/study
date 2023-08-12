<h3>req</h3>

- req.app: req 객체를 통해 app 객체에 접근할 수 있다. req.app.get('port')와 같은 식으로 사용할 수 있다.
- req.body: body-parser 미들웨어가 만드는 요청의 본문을 해석한 객체
- req.cookies: cookie-parser 미들웨어가 만드는 요청의 쿠키를 해석한 객체
- req.params: 라우트 매개변수에 대한 정보가 담긴 객체
- req.query: 쿼리스트링의 키-값 정보 
예. /users/123?limit=5&skip=10 주소 요청 시에 req.params는 { id: '123' }, req.query는 { limit: '5', skip: '10' }
- req.signedCookies: 서명된 쿠키들은 req.cookies 대신 여기에 담겨 있음 

<br>
<h3>res</h3>

- res.app: req.app처럼 res 객체를 통해 app 객체에 접근할 수 있음 
- res.end(): 데이터 없이 응답을 보냄 
- res.json(JSON): JSON 형식의 응답을 보냄
- res.redirect(주소): 리다이렉트할 주소와 함께 응답을 보냄 
- res.render(뷰, 데이터): 템플릿 엔진을 렌더링해서 응답할 때 사용하는 메서드 
- res.send(데이터): 데이터와 함게 응답을 보냄 (데이터는 문자열일 수도, HTML일 수도, 버퍼일 수도, 객체나 배열일 수도 있음)
- res.sendFile(경로): 경로에 위치한 파일을 응답함 
- res.status(코드): 응답 시의 HTTP 상태 코드를 지정함 

<br>
<h3>method chaining</h3>

req나 res 객체의 메서드는 다음과 같이 메서드 체이닝을 지원한다. 이를 활용하면 코드양을 줄일 수 있다.

```
res
  .status(201)
  .cookie('test', 'test')
  .redirect('/admin');
```

<br>
<h3>참고</h3>

Node.js 교과서 - 기본부터 프로젝트 실습까지
