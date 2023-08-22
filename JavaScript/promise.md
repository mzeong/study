<h2>promise</h2>

- 내용이 실행은 되었지만 결과를 아직 반환하지 않은 객체 (결과를 나중에 원할 때 쓸 수 있다!)
- 콜백 헬이라고 불리는 지저분한 자바스크립트 코드의 해결책

promise 객체는 아래와 같은 문법으로 만들 수 있다.

```
const condition = true;
const promise = new Promise((resolve, reject) => {
	// executor (제작 코드)
	if (condition) {
		resolve('성공');
	} else {
		reject('실패');
	}
});
```

executor는 `new Promise`가 <u>만들어질 때 자동으로 실행</u>되는데 여기서 원하는 일이 처리된다. 처리가 끝나면 처리 성공 여부에 따라 `resolve`나 `reject`를 호출한다. 이때, promise 객체의 상태가 변화한다.

-   `state` - 처음엔 `“pending”`(보류)이었다 `resolve`가 호출되면 `“fulfilled”`, `reject`가 호출되면 `“rejected”`로 변한다.
-   `result` - 처음엔 `undefined`이었다 `resolve(value)`가 호출되면 `value`로, `reject(error)`가 호출되면 `error`로 변한다.

<br>
<h2>then, catch, finally</h2>

promise 객체의 `state`, `result`는 내부 프로퍼티이므로 개발자가 직접 접근할 수 없다. `.then`/`.catch`/`.finally` 메서드를 사용하면 접근 가능하다.

```
promise
	.then((message) => {
		console.log(message); //성공
	})
	.catch((error) => {
		console.log(error);
	})
```

<h3>then</h3>

promise에 `then`을 붙이면 결과를 반환한다.

<h3>catch</h3>

에러가 발생한 경우만 다루고 싶다면 `.then`의 첫 번째 인수로 `null`을 전달하면 된다. `.catch(f)`는 문법이 간결하다는 점만 빼고 `.then(null, f)`와 완벽하게 같다.

<h3>finally</h3>

결과가 어떻든 마무리가 필요하면 `finally`가 유용하다. `finally` 핸들러는 성공, 실패 여부를 몰라도 되기 때문에 인수가 없다. 또한, 자동으로 다음 핸들러에 결과와 에러를 전달한다.

<h3>promise chaining</h3>

promise chaining이 가능한 이유는 `promise.then`을 호출하면 promise가 반환되기 때문이다. 반환된 promise에는 당연히 `.then`을 호출할 수 있다. 

<br>
<h2>promise API</h2>

<h3>Promise.all</h3>

여러 개의 promise를 동시에 실행시키고 모든 promise가 준비될 때까지 기다릴 때 사용할 수 있다. 
(예. 복수의 URL에 동시에 요청을 보내고, 다운로드가 모두 완료된 후에 콘텐츠를 처리할 때)

요소 전체가 promise인 배열을 받고 새로운 promise를 반환한다. 

```
let promise = Promise.all([...promises...]);
```

배열의 요소 순서는 `Promise.all`에 전달되는 promise 순서와 상응한다.(첫 번째 promise는 가장 늦게 이행되더라도 처리 결과는 배열의 첫 번째 요소에 저장된다.)

`Promise.all`에 전달되는 promise 중 <u>하나라도 거부되면</u>, `Promise.all`이 반환하는 promise는 에러와 함께 바로 거부된다. 

<h3>Promise.allSettled</h3>

여러 요청 중 하나가 실패해도 다른 요청 결과는 여전히 필요할 때 `Promise.allSettled`를 사용할 수 있다. `Promise.allSettled`를 사용하면 각 promise의 상태와 값 또는 에러를 받을 수 있다.

<h3>Promise.race</h3>

`Promise.all`과 비슷하다. 다만 가장 먼저 처리되는 promise의 결과 혹은 에러를 반환한다. ('경주(race)의 승자'가 나타난 순간 다른 promise의 결과 또는 에러는 무시된다.)

<br>
<h2>참고</h2>

https://ko.javascript.info/
인간 JS 엔진 되기 (JS 고급 강좌)
