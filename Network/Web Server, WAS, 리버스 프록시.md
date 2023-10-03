> #### Web Server와 Web Application Server는 따로 존재한다. 
> 인터넷 사용자가 많지 않았던 초기 인터넷에서는 WAS가 필요없었다. WAS로 인해 미리 정해진(정적) 콘텐츠를 준비해두고 요청이 오면 응답으로 주는 것이 아닌, 요청이 올 때마다 해당 요청에 적절한 콘텐츠를 만들 수 있게(동적) 되었다. 

WAS는 어떻게 Web Server와 함께 동작할까? 그냥 냅다 노드 혹은 스프링을 실행시키면 Web Server가 없는 모습이 된다. 그러나 우리는 아래와 같은 모습을 원한다.

![Untitled](https://github.com/mzeong/Study/assets/70924556/39cf7213-918d-4de3-84ae-bd660b5a120d)

- 우리는 네이버에 그냥 `www.naver.com`으로 접속한다. 만약 네이버가 WAS 하나만 뒀다면 `www.naver.com:8080`(노드면 기본적으로 `3000`)으로 접속해야만 한다. 

`www.naver.com`은 사실 `www.naver.com:80`, 즉 Web Server로 요청을 보내는 건데 왜 응답은 WAS에서 줄까? 이 상황을 이해하기 위해서는 리버스 프록시를 알아야 한다.
 
### Reverse Proxy

- 클라이언트와 서버 간의 통신을 중계하고 보안, 성능 개선 등의 목적을 위해 **중간에 위치하는** 서버

프록시 서버는 대리자로써 우선 클라이언트의 요청을 받고 본 서버로 보내준다. 여기서 알아야 할 건, 한 번 서버는 영원한 서버로서 요청을 받기만 하는 건 아니라는 것이다. **서버 프로세스가 내부적으로** connect() 시스템 콜과 같은 **요청을 보내는 시스템 콜을 통해 다른 서버 프로세스에게 다시 요청을 보낼 수 있다.** 따라서 아래 그림과 같이 생각하면 된다.

![Untitled (1)](https://github.com/mzeong/Study/assets/70924556/ba6e40da-3db8-4efb-9be1-269c6fd174c6)

> 포워드 프록시는 또 다른 외부(다른 컴퓨터) 서버로 요청을 보내주고, 리버스 프록시는 내부(같은 컴퓨터)의 다른 서버로 요청을 보내준다.

<br>

### 참고

UMC Server 파트 워크북 - Chapter 3. Web Server & Web Application Server(WAS), Reverse Proxy
