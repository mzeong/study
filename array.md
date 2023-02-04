## 기능과 구현

임의의 위치에 있는 원소를 확인/변경 = O(1)

원소를 끝에 추가 = O(1)

마지막 원소를 제거 = O(1)

임의의 위치에 원소를 추가/임의 위치의 원소 제거 = O(N), 이후 원소들을 이동해야 해서

### insert 함수

```
void insert(int idx, int num, int arr[], int& len) {
	for (int i = len; i > idx; i--)
		arr[i] = arr[i-1];
	arr[idx] = num;
	len++;
}
```

### erase 함수

```
void erase(int idx, int arr[], int& len) {
	len--;
	for (int i = idx; i < len; i++)
		arr[i] = arr[i+1];
}
```

### 전체를 특정 값으로 초기화할 때

1. cstring 헤더에 있는 memset 함수, 실수할 여지가 많아 비추천
    
    0이나 -1이 아닌 다른 값을 넣거나, 2차원 이상의 배열을 인자로 넘기면 오작동
    
2. for문 
3. algorithm 헤더의 fill 함수, 실수할 여지도 별로 없고 코드도 짧으니 가장 추천 

```
fill(a, a+21, 0);
for (int i = 0; i < 21; i++)
	fill(b[i], b[i]+21, 0);
```

## STL vector

insert, erase는 시간복잡도가 O(N)

push_back, pop_back은 제일 끝에 원소를 추가하거나 빼는 것이니 O(1)

vector에서 =를 사용하면 deep copy가 발생한다.

```
for (int i = 0; i <= v1.size()-1; i++)
	cout << v1[i] << ' ';
```

**아주 잘못된 코드.** 기본적으로 vector의 size 메소드는 시스템에 따라 unsigned int 혹은 unsigned long long을 반환한다. unsigned int와 int를 연산하면 unsigned int로 자동 형변환이 발생하기 때문에 (unsigned int)0 - (int)1은 -1이 아니라 4294967295이 된다. 그래서 아무것도 출력하지 않고 종료되는 것이 아니라 런타임에러가 발생하게 될 것이다. 

## 참고

BaaaaaaaarkingDog 실전 알고리즘
