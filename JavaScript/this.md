<h2>this</h2>

자바스크립트에선 모든 함수에 `this`를 사용할 수 있다. 
`this`는 기본적으로 `window`이다.(strict 모드일 경우는 `undefined`) 함수에서 `this`는 `window`이다. 

`this`는 함수가 호출될 때 결정된다. 

<h3>1. 객체의 메서드</h3>

```
const obj = {
	name: 'John',
	sayName() {
		console.log(this.name);
	}
};
obj.sayName(); // John
```

객체 프로퍼티에 할당된 함수를 메서드라고 부른다. 메서드 내부에서 `this` 키위드를 사용하면 <b>객체</b>에 접근할 수 있다. 

> 메서드 단축 구문: `sayName: function() { ... }` 를 `sayName() { ...}` 으로 줄일 수 있다. 

> `const sayN = obj.sayName;` 을 하면 `sayN`은 더 이상 `obj`의 메서드가 아니고 그냥 함수이다. 

<h3>2. 생성자 함수</h3>

```
function Human(name) {
	this.name = name;
}
new Human('John');
```

`new` 키위드를 통해서 호출된 함수 내부에서의 `this`는 <b>객체 자기 자신</b>이 된다. 

<h3>3. call, apply, bind</h3>

명시적으로 `this`를 바꿀 수 있다. 
`call`과 `apply`는 함수를 호출할 때 `this`와 파라미터를 지정해준다. `call`과 다르게 `apply`는 파라미터를 배열의 형태로 전달한다.
`bind`는 함수를 가리키는 `this`만 바꾸고 호출하지는 않는다. 

<h3>4. 화살표 함수</h3>

부모의 `this`를 물려받는다.

```
const obj = {
	name: 'John',
	sayName() {
		console.log(this.name);
		function inner() {
			console.log(this.name);
		}
		inner();
	}
}
obj.sayName(); 
// John
// ''
```

- `inner`를 화살표 함수로 바꾸면 `''`이 아니라 `John`이 출력된다. 

<br>
<h2>참고</h2>

모던 JavaScript 튜토리얼

인간 JS 엔진 되기 (JS 고급 강좌)
