### Map

객체와 유사한 자료구조 
- 공통점: 키가 있는 데이터를 저장한다.
- 차이점: 키의 타입에 제약이 없다. `size` 프로퍼티 등 유용한 메서드나 프로퍼티가 있다. 

Map에는 다음과 같은 주요 메서드와 프로퍼티가 있다.

- `new Map()` 
- `map.set(key, value)` : **키로 객체를 허용한다.**
- `map.get(key)` : `key`가 존재하지 않으면 `undefined`를 반환한다. 
- `map.has(key)` 
- `map.delete(key)`
- `map.clear()`
- `map.size`

> **`map[key]`는 Map을 쓰는 바른 방법이 아니다.** 이 방법은 `map`을 일반 객체처럼 취급하게 되어 여러 제약이 생긴다. 전용 메서드인 `set`, `get` 등을 사용하자.

<br>

### Set

배열과 유사한 자료구조로, 중복이 없는 값을 저장할 때 쓰인다. 

> 배열에 저장한 후, `arr.find()`를 이용하여 중복 값 여부를 확인할 수도 있다. 하지만, `arr.find()`는 배열 내 요소 전체를 뒤져 중복을 찾기 때문에 Set보다 성능 면에서 떨어진다. 반면, Set은 값의 유일무이함을 확인하는데 최적화되어 있다.

주요 메서드는 다음과 같다.

- `new Set(iterable)` : 이터러블 객체를 전달받으면(대개 배열을 전달받음) 그 안의 값을 복사해 Set에 넣어준다. 
- `set.add(value)` 
- `set.delete(value)` : 호출 시점에 Set 내에 값이 있어서 제거에 성공하면 `true`, 아니면 `false`를 반환한다.
- `set.has(value)`
- `set.clear()`
- `set.size`

<br>

### 참고

Node.js 교과서 - 기본부터 프로젝트 실습까지

모던 JavaScript 튜토리얼
