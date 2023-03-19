## next_permutation

백트래킹만으로 순열과 조합 문제를 해결하면 코드가 길어지고 실수할 여지 생길 수 있다. 이때 next_permutation 함수를 쓰면 깔끔하게 해결할 수 있다.

### 1 2 3을 가지고 만들 수 있는 모든 순열

```
int a[3] = {1, 2, 3};
do {
	for (int i = 0; i < 3; i++)
		cout << a[i];
	cout << '\n';
} while (next_permutation(a, a+3));

/*
123
132
213
231
312
321
*/
```

### 1 2 3 4에서 순서 없이 수 2개를 뽑는 모든 경우

```
int a[4] = {0, 0, 1, 1};
do {
	for (int i = 0; i < 4; i++)
		if (a[i] == 0) cout << i+1;
	cout << '\n';
} while (next_permutation(a, a+4));

/*
12
13
14
23
24
34
*/
```

### BOJ 15649_N과 M (1)

- 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열

```
for (int i = 0; i < n; i++) arr[i] = i + 1;
do {
	for (int i = 0; i < m; i++)
		cout << arr[i] << ' ';
	cout << '\n';
	reverse(arr + m, arr + n);
} while(next_permutation(arr, arr + n));
```

### BOJ 15650_N과 M (2)

- 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
- 오름차순

```
for (int i = m; i < n; i++) arr[i] = 1;
do {
	for (int i = 0; i < n; i++)
		if (arr[i] == 0) cout << i + 1 << ' ';
	cout << '\n';
} while(next_permutation(arr, arr + n));
```

## 참고

BaaaaaaaarkingDog 실전 알고리즘
