### module

노드는 자바스크립트코드를 모듈로 만들 수 있다. 모듈로 만들면 여러 프로그램에서 재사용 가능하다.  
- 파일 끝에 `module.exports`로 모듈로 만들 값을 지정한다. 다른 파일에서 `require(파일 경로)`로 그 모듈의 내용을 가져올 수 있다. 
- `module.exports` 외에도 `exports`로 모듈을 만들 수 있다. `module.exports`와 `exports`는 하나의 객체를 참조한다. 좀 더 정확히 말하면 `exports -> module.exports -> {}`의 관계를 가지고 있다.

<br>

### this 

- 노드에서 최상위 스코프의  `this`는 `module.exports`를 가리킨다. 
- 함수 선언문 내부의 `this`는 `global` 객체를 가리킨다. 
	- `global`은 노드의 전역 객체로 브라우저의 `window`같은 역할이다. `global` 속성에 값을 대입하면 다른 파일에서도 사용 가능하다. 

<br>

### ES 모듈 

| 차이점 | CommonJS 모듈 | ECMAScript 모듈 |
| --- | --- | --- |
| 문법 | `require('./a');` <br> `const A = require('./a');` <br> `const { C, E } = require('./b');` <br> `module.exports = A;` <br>  `exports.C = D;` <br> `const E = F; exports.E = E;` <br>  | `import './a.mjs';` <br> `import A from './a.mjs';` <br> `import { C, E } from './b.mjs';` <br> `export default A;` <br> `export const C = D;` <br> `const E = F; export { E };` | 
| 확장자 | js <br> cjs | js (package.json에 `"type": "module"` 필요) <br> mjs |
| 확장자 생략 | 가능 | 불가능 |
| 인덱스(index) 생략 | 가능 | 불가능 |
| 다이내믹 임포트 | 불가능 | 가능 |
| top level await | 불가능 | 가능 |
| __filename, __dirname, <br> require, module.exports, exports | 사용 가능 | 사용 불가능 <br> (__filename 대신 import.meta.url 사용) |
| 서로 간 호출 | 가능 | 가능 | 

> #### 다이내믹 임포트 
> 조건부로 큰 모듈을 가져올 때 사용하는 것이 좋다. 

<br>

### 참고 

Node.js 교과서 - 기본부터 프로젝트 실습까지
