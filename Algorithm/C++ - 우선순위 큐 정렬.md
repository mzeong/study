원하는 순서대로 우선순위 큐를 출력하려면 **비교 연산자를 재정의**해야 한다. **구조체를 만들어서 `operator()`를 오버로딩한다.**

```c++
//priority_queue<자료형, 구현체, 비교연산자> pq;
priority_queue<int, vector<int>, cmp> pq;

struct cmp {
	bool operator()(int a, int b) {
		return a > b; //작은 값부터 나옴
	}
};
```

- vector와 같은 자료구조로 sort를 할 때와는 반대이다. <br>vector는 앞에서부터 값을 참조하고, priority_queue는 뒤에서부터 값을 참조하므로 비교 함수가 반대로 작성된다. 

<br>

### 참고

https://real-012.tistory.com/59
