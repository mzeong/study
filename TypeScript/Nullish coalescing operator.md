### Nullish coalescing operator 

왼쪽 피연산자가 `null` 또는 `undefined`일 때 오른쪽 피연산자를 반환하고, 그렇지 않으면 왼쪽 피연산자를 반환하는 논리 연산자 

```ts
const foo = null ?? 'default string';
console.log(foo);
// Expected output: "default string"

const baz = 0 ?? 42;
console.log(baz);
// Expected output: 0
```

> #### 논리 연산자 OR와의 차이
> 논리 연산자 OR (`||`)는 왼쪽 피연산자가 `null` 또는 `undefined`일 때 뿐만 아니라 <ins>`falsy` 값(`''` 또는 `0`)에 해당할 경우에도</ins> 오른쪽 피연산자를 반환한다. 
> ```ts
> const baz = 0 || 42;
> console.log(baz);
> // Expected output: 42
> ```

<br>

### 참고

MDN Web Docs
