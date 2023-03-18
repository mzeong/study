CSS에서 속성을 줄 대상을 선택자라고 한다. ([대표적인 선택자 알아보기](http://www.tcpschool.com/css/css_selector_basic), [연습 사이트: CSS Diner](https://flukeout.github.io/))

선택자 사이의 공백 유무에 따라 자손 선택자와 다중 선택자로 나뉜다.

- 특정 부모 요소 안에 있는 자식 요소만을 선택하고 싶다면 공백으로 연결(자손 선택자)
- 중첩된 선택자들을 모두 만족하는 요소를 선택하고 싶다면 공백 없이 연결(다중 선택자)

선택자 뒤에 `:가상 이벤트`를 붙이면 특정 이벤트마다 적용할 스타일을 설정할 수 있다.(가상 클래스 선택자)

- `:first-child` : 모든 형제 요소 중 첫 번째 요소를 선택
- `:last-child`
- `:nth-child(n)` : n의 위치에서 짝수(`2n`), 홀수(`2n-1`) 등의 연산이 가능하다.
- `:hover` : 마우스를 요소에 올렸을 때
- `:first-of-type` : 형제 요소 중 자신의 유형과 일치하는 제일 첫 요소를 취급한다. 마찬가지로 `:last-of-type`, `:nth-of-type(n)`이 있다.

```html
<div class="container">
		<h1>제목입니다.</h1>
		<p>첫 번째 p입니다.</p>
		<p>두 번째 p입니다.</p>
		<span>첫 번째 span입니다.</span>
		<p>세 번째 p입니다.</p>
</div>
```

```css
.container p:first-child {  // 적용X
    background-color: red;
}

.container p:first-of-type { // 적용O
    background-color: blue;
}
```

- `:active` : 활성화된 요소를 선택
- `:focus` : focus를 받고 있는 입력창들의 요소를 선택
- `:visited` : 사용자가 방문한 적 있는 링크를 선택 (기본적으로 보라색으로 표시한다.)

HTML을 길게 쓰지 않고도 CSS만으로도 가상 요소를 만들거나 조작할 수 있다. (가상 요소 선택자)⭐반드시 content 속성을 이용해서 요소 내에 들어갈 내용을 작성해주어야 한다.

- `:before`, `:after`

```html
<!-- 가상 요소 선택자 사용 전 -->

<div class="box1">
 나는 박스1입니다.
 <p class="text">나는 박스2입니다.</p>
</div>

<!-- 가상 요소 선택자 사용 후 -->

<div class="box1">
 나는 박스1입니다.
</div>
```

```css
.box1{
        width : 200px;
        height: 300px;
        background-color: yellow;
    }
/* 가상 요소 선택자 사용 전 */
.text{
        background-color: blue;
    }

/* 가상 요소 선택자 사용 후 */
.box1:after{
    content:"나는 박스2입니다.";
    display: block;
    background-color: blue;
}
```

`A ~ B` 를 통해 A와 같은 부모를 가지고 있는 형제 요소 중 B를 선택할 수 있다. (형제 요소 선택자)

```html
<div class="container">
	 <p class="text">나는 text입니다.</p>
	 <span>나는 span입니다.</span>
	 <span>나는 span입니다.</span>
	 <p>나는 p입니다.</p>
	 <p>나는 p입니다.</p>
</div>
```

```css
.text ~ span {
	background : red
}
// text의 부모가 container이므로
// container의 자식 중 span을 골라
// 배경을 빨간색으로 바꿔줌
```

## 참고

인프런x코드캠프 - 시작은 프리캠프

인프런x코드캠프 - 강력한 CSS
