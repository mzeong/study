JavaScript는 HTML을 조작하고 변경하기 위해 쓴다.

## 셀렉터(selector)

‘안녕하세요’가 ‘안녕’으로 바뀐다.

```
<body>
	<h2 id="hello">안녕하세요</h2>
	<script>
		document.getElementById('hello').innerHTML = '안녕';
	</script>
</body>
```

바꾸고 싶은 HTML 요소의 id를 넣고, 뭘 바꿀지 뒤에 적는다. 구글에 검색해서 찾으면 된다.

```
document.getElementById('???').??? = '???';
```

글자가 빨간색으로 바뀐다.

```
document.getElementById('hello').style.color = 'red';
```

글자 사이즈를 30px로 바꿔봤다.

```
document.getElementById('hello').style.fontSize = '30px';
```

Id 말고도 여러 개가 있다. 

```
document.getElementByClassName('alert-box')[0]
```

## Alert UI 만들기

UI 만드는 법은 간단하다. 미리 디자인 해놓고 숨긴 다음, 버튼 누르거나 하면 보여주면 된다.

onclick 안에 JS를 쓸 수 있다.(길게 작성은 안 한다) 버튼을 누르면 alert 창이 보인다. 

```
<button onclick="document.getElementById('alert').style.display = 'block'; ">버튼</button>
```

클릭 시 alert 창이 사라지도록 닫기 버튼을 추가해봤다.

```
<div class="alert-box" id="alert">
	<p>Alert 박스</p> 
	<button onclick="document.getElementById('alert').style.display = 'none'; ">닫기</button>
</div>
```

## Function

한글로 작명해도 된다. 이때 변경할 HTML 요소는 위에, JS로 조작은 밑에서 하는 것이 정석이다. JS로 조작을 위에서 하면 에러가 난다.

```
<button onclick="알림창열기()">버튼</button>
<script>
	function 알림창열기(){
	document.getElementById('alert').style.display = 'block';
}
</script>
```

동일하게 닫기 버튼도 function으로 축약하면 된다. 코드는 생략한다. 

## 파라미터

파라미터를 이용하면 하나의 함수로 해결할 수 있다. 

```
<div class="alert-box" id="alert">
	<p>Alert 박스</p>
	<button onclick="알림창열기('none')">닫기</button>
</div>
<button onclick="알림창열기('block')">버튼</button>
```

alert 창을 하나 더 만들고 싶다면 또 작성하지 말고 JS를 이용해 UI를 재활용하면 된다.

```
<button onclick="알림창1열기('아이디입력해라')">버튼1</button>
<button onclick="알림창1열기('비번입력해라')">버튼2</button>
<script>
	function 알림창1열기(구멍) {
		document.getElementById('title').innerHTML = 구멍;
    document.getElementById('alert').style.display = 'block';
	}
</script>
```

## EventListener

onclick 쓰지 않고 똑같은 효과를 낼 수 있다. 이 요소가 클릭되면 이 코드를 실행해 달라는 의미다. 

```
<script>
	document.getElementById('close').addEventListener('click', function(){
		document.getElementById('alert').style.display = 'none';
	})
</script>
```

## jQuery

라이브러리로 JS 코드 양을 줄일 수 있다. 요즘은 React를 쓰지만 기존에 jQuery로 개발된 사이트가 많아서 안 배울 수는 없다. 

### 설치 방법

구글에 jQuery CDN 검색해서 <body> 끝나기 전에 복붙하면 된다. 그 하단부터 jQuery 문법 사용이 가능하다. ([https://releases.jquery.com/](https://releases.jquery.com/)) 

- umcompressed = 그냥 원본 파일
- minified = 공백 제거 버전
- slim = 기능 많이 빠진 라이트 버전

### 코드

괄호 안에 CSS 셀렉터처럼 작성하면 된다. 클래스라면 `.test1` 로 쓰면 된다. `html()`은 모든 요소, `text()`는 텍스트만을 대상으로 한다. 

```
$('#test').html('안녕');
$('#test').text('안녕');
```

JS로 쓰면 아래와 비슷하다. 다만, `querySelector()`는 일치하는 첫 번째 요소만 가져온다. 모든 요소를 원하면 `querySelectorAll()`과 인덱스를 사용해야 한다. 

$() 셀렉터는 여러 개가 있으면 전부 찾아줘서 순서 지정이 필요 없고, 한 번에 조작과 변경할 수 있다. 

```
document.querySelector('#test')
document.querySelectorAll('#test')[0]
```

HTML 출력은 괄호 안에 아무것도 안 쓰면 된다. 

```
$('#test').html();
```

이외에도 HTML 스타일 변경을 하고 싶다면 `css()`, 다른 걸 변경하고 싶다면 `attr()`을 쓰면 된다.

```
$('#test').css('color', 'red');
$('#test').attr('src', '???')
```

`addEventListener` 대신 `on`을 쓰면 된다. `hide()`는 사라지게, `fadeOut()`은 서서히 사라지게, `slideUp()`은 줄어들며 사라지게 만들어준다. 

```
$('#test-btn').on('click', function() {
	$('.hello').hide();
})
```

## Bootstrap

복붙식으로 개발할 수 있다. <head> 안에 CSS 파일, <body> 끝나기 전에 JS 파일을 붙여넣으면 된다.

[https://getbootstrap.com/docs/5.1/getting-started/introduction/#starter-template](https://getbootstrap.com/docs/5.1/getting-started/introduction/#starter-template)

## 클래스 탈부착식 구현

클래스 탈부착식으로 개발하면 애니메이션 추가가 쉽고, 나중에 재사용이 편리하다. 

메뉴 버튼을 누르면 서브 메뉴가 등장하게 할 것이다. 숨겨 놓은 요소에 show라는 클래스를 부착하면 구현할 수 있다. 더 하단에 작성한 것이 우선 적용되기 때문이다.

```
.list-group {
    display: none;
}

.show {
    display: block;
}
```

class명을 원하는 요소에 추가하는 법은 `add()`, 제거하는 법은 `remove()`이다. 여기서는 버튼을 한 번 더 누르면 서브메뉴를 다시 숨기기 위해 `toggle()`을 썼다. `toggle()`은 클래스명이 있으면 제거하고, 없으면 붙여줘서 왔다갔다하는 UI를 만들 때 유용하다.

```
<script>
	document.getElementsByClassName('navbar-toggler')[0].addEventListener('click', function(){
		document.getElementsByClassName('list-group')[0].classList.toggle('show');
	})
</script>
```

jQuery로는 아래처럼 쓸 수 있다. 

```
$('.navbar-toggler').on('click', function(){
	$('.list-group').toggleClass('show');
})
```

## UI 애니메이션

애니메이션 추가는 가능하면 CSS만으로 처리하는 게 더 빠르고 효율적이다.

### one-way 애니메이션 만드는 법

1. 시작 스타일과 최종 스타일을 class로 만들고

```
.black-bg {
	...
  visibility : hidden;
  opacity : 0;
}

.show-modal {
  visibility : visible;
  opacity : 1;
}
```

1. 원할 때 최종 스타일로 변하라고 JS 코드를 짠다.

```
$('#login').on('click', function() {
	$('.black-bg').addClass('show-modal');
})
```

1. 시작 스타일에 transition을 추가한다. 

```
.black-bg {
  (생략)
  visibility : hidden;
  opacity : 0;
  transition : all 1s;
}
```

### 응용

서브 메뉴가 내려오면서 보인다. 

```
.list-group {
    visibility: hidden;
    transition: all 1s;
    overflow: hidden;
    height: 0px;
}

.show {
    visibility: visible;
    height: 220px;
}
```

## Form

form은 서버로 유저 정보를 전송하려고 쓰는 것이다. 전송 버튼을 누르면 form이 전송되며 success.html로 이동한다. 

```
<form action="success.html">
  ...
</form>
```

전송 버튼의 타입은 `submit`, 일반 버튼의 타입은 `button`이 되어야 한다. 

```
<button type="submit" class="btn btn-primary">전송</button>
<button type="button" class="btn btn-danger" id="close">닫기</button>
```

폼이 전송되면 submit 이벤트가 발생한다. input에 입력한 값이 공백이라면 알림이 뜨게 했다.

이벤트리스너 콜백함수에 파라미터 e를 추가해주고 `e.preventDefault()`를 쓰면 폼전송이 안 된다.

```
$('form').on('submit', function(e){
	if (document.getElementById('email').value == '') {
		alert('아이디를 입력하세요');
    e.preventDefault();
	}
});
```

<input> 태그에서 발생하는 이벤트가 있다.

- input : <input> 안에 뭔가 입력할 때 발생
- change : <input> 안에 뭔가 입력하고 커서를 다른 곳으로 옮기면 발생
  
 ## 참고

coding apple - JavaScript 입문과 웹 UI개발
