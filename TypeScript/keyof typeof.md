### 객체에서 `keyof typeof` 사용하기

객체의 타입을 모르거나 다음과 같이 값만 있고 해당 값의 유형이 없는 경우에 어떻게 해야 할까?
```
const bmw = { name: "BMW", power: "1000hp" }
```
이때 우리는 `keyof typeof`를 함께 사용해야 한다.

`typeof bmw`를 사용하면 타입을 얻을 수 있다: `{ name: string, power: string }`
그런 다음 `keyof` 연산자는 다음과 같이 리터럴 타입 유니온을 제공한다:

```ts
type CarLiteralType = keyof typeof bmw

let carPropertyLiteral: CarLiteralType
carPropertyLiteral = "name"       // OK
carPropertyLiteral = "power"      // OK
carPropertyLiteral = "anyOther"   // Error...
```

<br>

### 이넘에서는 보통 `keyof` 대신 `keyof typeof`를 사용한다. 

타입스크립트에서, 이넘은 컴파일 시간에 상수값의 타입 안정성을 확보하기 위해 사용되지만, <ins>런타임에는 객체로 취급된다.</ins> 이는 타입스크립트 코드가 자바스크립트로 컴파일될 때 이넘이 일반 객체로 변환되기 때문이다. 따라서 위의 객체에 대한 설명이 여기에도 적용된다.

```ts
enum ColorsEnum {
    white = '#ffffff',
    black = '#000000',
}

type Colors = keyof typeof ColorsEnum

let colorLiteral: Colors
colorLiteral = "white"  // OK
colorLiteral = "black"  // OK
colorLiteral = "red"    // Error...
```

<br>

### 참고

https://stackoverflow.com/questions/55377365/what-does-keyof-typeof-mean-in-typescript
