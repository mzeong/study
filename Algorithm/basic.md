## 시간복잡도

| N의 크기 | 허용 시간복잡도 |
| --- | --- |
| N ≤ 11 | O( $N!$ ) |
| N ≤ 25 | O( $2^N$ ) |
| N ≤ 100 | O( $N^4$ ) |
| N ≤ 500 | O( $N^3$ ) |
| N ≤ 3,000 | O( $N^2lgN$ ) |
| N ≤ 5,000 | O( $N^2$ ) |
| N ≤ 1,000,000 | O( $NlgN$ ) |
| N ≤ 10,000,000 | O( $N$ ) |
| 그 이상 | O( $lgN$ ), O( $1$ ) |

## 공간복잡도

메모리 제한이 512MB일 때 int 변수를 대략 1.2억개 정도 선언할 수 있다. (int 1개가 4바이트)

## 정수 자료형

만약 문제에서 unsigned long long 범위를 넘어서는 수를 저장할 것을 요구한다면 string을 활용해서 저장해야 한다. 만에 하나 나왔다면 그냥 Python을 쓰는 게 편하다.

## 실수 자료형

1. 실수의 저장/연산 과정에서 반드시 오차가 발생할 수 밖에 없다. 두 자료형끼리 차이가 굉장히 크기 때문에 실수 자료형이 필요하면 꼭 double을 써야 한다. (float는 6자리, double은 15자리)
2. double에 long long 범위의 정수를 함부로 담으면 안 된다. (long long은 최대 19자리)
3. 실수를 비교할 때는 등호를 사용하면 안 된다.

## 함수 인자

int와 구조체는 값 전달, int 배열은 주소 전달이다.

STL도 복사본을 만들어서 보내기 때문에 두 vector의 크기가 N이라고 할 때 cmp1 함수의 시간복잡도는 O(N)이 된다. (원본으로부터 복사본을 만드는 비용이 드는 것) cmp2 함수처럼 참조자를 이용하면 O(1)의 시간복잡도를 가질 수 있다.

```
bool cmp1(vector<int> v1, vector<int> v2, int idx) {
	return v1[idx] > v2[idx];
}
```

```
bool cmp2(vector<int>& v1, vector<int>& v2, int idx) {
	return v1[idx] > v2[idx];
}
```

## 참조자

두 변수를 swap하고 싶다면 swap1 함수처럼 포인터를 보내거나, swap2 함수처럼 참조자로 해결할 수 있다. 참조자로 만들면 함수 내의 코드에서는 그냥 int를 쓰듯이 대입해 원본을 바꿀 수 있다.

```
void swap1(int* a, int* b) {
	int tmp = *a;
	*a = *b;
	*b = tmp;
}
```

```
void swap2(int& a, int& b) {
	int tmp = a;
	a = b;
	b = tmp;
}
```

## 표준 입출력

scanf와 cin 모두 공백을 포함한 문자열을 입력받을 때 공백 앞까지만 입력을 받는다. 추천하는 방법은 getline을 이용하는 것이다. 

```
string s;
getline(cin, s);
cout << s;
```

ios::sync_with_stdio(0), cin.tie(0) 꼭 넣고 endl 절대 쓰지 말 것

## 참고

BaaaaaaaarkingDog 실전 알고리즘
