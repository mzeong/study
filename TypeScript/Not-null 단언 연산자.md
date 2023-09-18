### Non-null assertion operator

타입스크립트에서 접미에 붙은 `!`는 typescript type checker에게 <ins>적용된 피연산자가 `null`이나 `undefined`가 아니다!</ins> 라고 단언하게 해주는 연산자이다. 

```ts
const toUpperCase = (givenStr: string | null) => {
    return givenStr!.toUpperCase()
}
```

하지만 정말 인자로 `null | undefined` 값이 들어가지 않을 것이라고 확신할 수 있을까?
코드가 길어지더라도 아래와 같이 Type Guard를 통해 인자로 `null`이 들어올 수 있는 상황에 대비하면서, type checker의 불평 또한 해소할 수 있다. 
```ts
const toUpperCase = (givenStr: string | null) => {
  if (givenStr === null) return null;
  return givenStr.toUpperCase();
};
```

또한, 다른 방식으로 optional chaining(`?.`)과 nullish coalescing operator(`??`)를 사용할 수 있다.

```ts
const  toUpperCase = (givenStr: string | null) => { 
	return givenStr?.toUpperCase() ?? null; 
};
```

<br>

### 참고

https://hwani.dev/ts-non-null-assertion-operator/
