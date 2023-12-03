### CORS (Cross-Origin Resource Sharing) 

서버가 웹 브라우저에서 리소스를 로드할 때 다른 오리진을 통해 로드하지 못하게 하는 HTTP 헤더 기반 메커니즘

> **오리진**: 프로토콜과 호스트 이름, 포트의 조합을 말한다. 예를 들어 `https://kundo.com:12010/test`라는 주소에서 오리진은 `https://kundo.com:12010`을 뜻한다. 

프런트엔드 개발 시 프런트엔드 서버를 만들어서 백엔드 서버와 통신할 때 주로 CORS 에러를 마주치는데, 이를 해결하기 위해 프런트엔드에서 프록시 서버를 만들기도 한다. 

- 예를 들어 프런트엔드에서는 127.0.0.1:3000으로 테스팅을 하는데 백엔드 서버는 127.0.0.1:12010이라면 포트 번호가 다르기 때문에 CORS 에러가 나타난다. 
- 이때 프록시 서버를 둬서 프런트엔드 서버에서 요청되는 오리진을 127.0.0.1:12010으로 바꾼다. 

<img width="338" alt="image" src="https://github.com/mzeong/Study/assets/70924556/6608ff5e-58c8-4dea-855d-0dde3b0f3482">
<img width="341" alt="image" src="https://github.com/mzeong/Study/assets/70924556/f458abaa-866e-4e66-be72-de836c18cef2">

<br>

### 참고

면접을 위한 CS 전공지식 노트 
