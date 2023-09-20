### Use `instanceof` for custom types

```
var ClassFirst = function () {};
var ClassSecond = function () {};
var instance = new ClassFirst();

typeof instance; 					//'object'
typeof instance == 'ClassFirst'; 	//false
instance instanceof Object; 		//true
instance instanceof ClassFirst; 	//true
instance instanceof ClassSecond; 	//false
```

### Use `typeof` for simple built in types

```
'example string' instanceof String; //false
typeof 'example string' == 'string' //true

'example string' instanceof Object 	//false
typeof 'example string' == 'object' //false

true instanceof Boolean; 	//false
typeof true == 'boolean' 	//true

99.99 instanceof Number; 	//false
typeof 99.99 == 'number'; 	//true

function() {} instanceof Function; 	//true
typeof function() {} == 'function'; //true
```

### Use `instanceof` for complex built in types

```
/regularexpression/ instanceof RegExp; //true
typeof /regularexpression/; //'object'
[] instanceof Array; //true
typeof []; //'object'
{} instanceof Object; //true
typeof {}; //'object'
```

<br>

### `typeof null`
null은 객체가 아니라 기본타입이지만, 자바스크립트 초기 버전의 버그로 `object`가 뜬다.

```
typeof null;  //'object'
```

따라서 `===`로 타입 체크를 하는 것이 좋다. 

<br>

### 참고

https://stackoverflow.com/questions/899574/what-is-the-difference-between-typeof-and-instanceof-and-when-should-one-be-used
