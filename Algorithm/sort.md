제일 끝부터 가장 큰 원소가 오도록 정렬하는 코드를

```
for (int i = n-1; i > 0; i--) {
	int mxidx = 0;
	for (int j = 1; j <= i; j++) {
		if (arr[mxidx] < arr[j]) mxidx = j;
	}
	swap(arr[mxidx], arr[i]);
}
```

max_element 함수를 이용해 드라마틱하게 코드의 길이를 줄일 수 있다. 여전히 O(N^2)에 동작한다. 

```
for (int i = n-1; i > 0; i--) {
	swap(*max_element(arr, arr+i+1), arr[i]);
}
```

## Merge Sort

### 시간복잡도

분할하는 과정에서 함수 호출은 1+2+4+…+2^k = 2N-1 = O(N)번 발생한다. 

합쳐나갈 땐 각 줄에서 모두 N번의 연산이 필요하고, 줄은 k개이니 O(NlgN)이다.

O(N)보다 O(NlgN)이 더 크기 때문에 최종적으로 머지 소트는 O(NlgN)의 시간복잡도를 가진다.

### 코드

```
void merge(int st, int en){
  int mid = (st + en) / 2;
  int l = st, r = mid;
  for(int i = st; i < en; i++){
    if(r == en) tmp[i] = arr[l++];
    else if(l == mid) tmp[i] = arr[r++];
    else if(arr[l] <= arr[r]) tmp[i] = arr[l++];
    else tmp[i] = arr[r++];
  }
  for(int i = st; i < en; i++) arr[i] = tmp[i];
}

void merge_sort(int st, int en){
  if(en == st + 1) return; // 리스트의 길이가 1인 경우
  int mid = (st + en) / 2;
  merge_sort(st, mid); 
  merge_sort(mid, en); 
  merge(st, en);
}
```

### Stable Sort

우선 순위가 같은 원소들끼리는 원래의 순서를 따라가도록 하는 정렬 

이 성질을 만족시키려면 앞에서 본 것처럼 앞 리스트에서 현재 보는 원소와 뒤 리스트에서 현재 보는 원소의 우선 순위가 같을 때 앞 리스트의 원소를 먼저 보내줘야 한다.

## Quick Sort

코딩테스트에서 STL을 못 쓰고 직접 정렬을 구현해야 하면 절대 퀵소트는 쓰지 말 것

퀵소트의 장점은 추가적인 공간이 필요하지 않는다는 것이다.(In-Place Sort) 또 그렇게 그 배열 안에서의 자리 바꿈만으로 처리가 되기 때문에 cache hit rate가 높아서 속도가 빠르다는 장점도 따라온다. 

### 코드

```
void quick_sort(int st, int en) { 
  if(en <= st+1) return;
  int pivot = arr[st], l = st+1, r = en-1;
  while(1){
    while(l <= r && arr[l] <= pivot) l++;
    while(l <= r && arr[r] >= pivot) r--;
    if(l > r) break;
    swap(arr[l], arr[r]);
  }
  swap(arr[st], arr[r]);
  quick_sort(st, r);
  quick_sort(r+1, en);
}
```

### 시간복잡도

pivot을 제자리로 보내야 하는 리스트들의 길이의 합은 N이어서 각 단계마다 O(N)이 필요하다. 

pivot이 매번 완벽하게 중앙에 위치해서 리스트를 균등하게 둘로 쪼갠다면 단계의 개수는 머지 소트때와 같이 lgN이 될 것이고 이 경우에는 퀵소트의 시간복잡도가 O(NlgN)이다. 

물론 늘 pivot이 중앙에 위치하는 이상적인 상황이 생기지는 않겠지만 pivot이 매번 어느 정도로만 잘 자리 잡는다면 시간복잡도는 여전히 O(NlgN)이다. 하지만 pivot이 중앙에 가는 대신 제일 왼쪽에 위치하게 되면 단계는 lgN개가 아닌 N개가 된다. 즉, 퀵소트의 시간복잡도는 평균적으로 O(NlgN)이지만 최악의 경우 O(N^2)이다. 

### 비교

|  | Merge Sort | Quick Sort |
| --- | --- | --- |
| 시간복잡도 | O(NlgN) | 평균 O(NlgN), 최악 O(N^2)
단 평균적으로 머지보다 빠름 |
| 추가적으로 필요한 공간 (Overhead) | O(N) | O(1) |
| Stable Sort 여부 | O | X |

## Counting Sort

수의 범위가 어느 정도 한정적(대략 1000만 이하)일 때에만 사용할 수 있다. 

수의 범위가 K개라고 할 때 처음 N개의 수를 보면서 freq 배열에 값을 추가하고 답을 출력할 때, 혹은 정렬을 수행할 때 총 K칸의 값을 확인해야 하기 때문에 O(N+K)이다. 

## Radix Sort

자릿수를 이용해서 정렬을 수행하는 알고리즘으로, 카운팅 소트를 응용한 알고리즘이라고도 생각할 수 있다.

자릿수의 최대 개수가 D개라고 할 때 D번에 걸쳐서 카운팅 소트를 하는 것과 상황이 똑같다. 그러면 리스트의 개수를 K개라고 할 때 엄밀하게 말하면 시간복잡도는 O(D(N+K))이지만 보통 리스트의 개수는 N에 비해 무시가 가능할 정도로 작다. 따라서 시간복잡도는 O(DN)이다. 

N개의 원소를 정렬할 때 한 리스트에 N개의 원소가 다 몰릴 수도 있으니 모든 리스트를 N칸의 배열로 만들어야 하는데 이건 공간의 낭비가 심하다. 공간의 낭비를 해결하려면 각 리스트를 vector와 같은 동적 배열 혹은 연결 리스트로 사용해야 한다. 그런데 둘다 STL이 없으면 구현이 까다롭고, STL을 쓸 수 있는 상황이라면 그냥 STL sort 함수를 쓰고 말지 굳이 라딕스 소트를 직접 짜고 있지는 않을 것이다. 그렇게 때문에 코테에서 머지나 기타 다른 소트를 구현할 일도 STL을 쓸 수 없는 아주 드문 환경 이외에는 없지만, 특히 라딕스 소트는 구현을 해야하는 상황이 아예 없다.

퀵, 버블 소트는 원소들끼리 크기를 비교하는 과정이 있었는데 카운팅, 라딕스 소트는 원소들간의 크기를 비교하지 않고 정렬을 수행한다. 그래서 버블, 머지, 퀵 소트는 Comparison Sort인 반면 카운팅, 라딕스 소트는 Non-comparison Sort이다. 

## STL sort

```
sort(a, a + 5);
sort(b.begin(), b.end()); // or sort(b.begin(), b.begin() + 5);
```

최악의 경우에도 O(NlgN)을 보장한다. 다만 stable sort가 아니다. 그래서 동일한 우선순위를 가진 원소들 사이의 상대적인 순서가 보존되지 않을 수 있다. 꼭 stable sort가 필요하다면 stable_sort 함수를 사용하면 된다. 

STL sort에는 비교 함수를 정해서 넘겨줄 수 있다. cmp(int a, int b)는 a가 b의 앞에 와야 할 때만 true를, 그렇지 않을 때에는 false를 반환해야 한다. 

- 두 값이 같을 때(혹은 우선순위가 같을 때)에는 반드시 false를 반환해야 한다.

```
bool cmp(int a, int b){
	return a > b;
}
// or sort(v.begin(), v.end(), greater<>());
```

- 비교 함수의 인자로 STL 혹은 클래스 객체를 전달 시 reference를 사용하는 것이 좋다. (함수의 인자로 STL이나 구조체 객체를 실어서 보내면 복사라는 불필요한 연산을 추가로 하게 된다.)

```
bool cmp(const string& a, const string& b) {
	return a.back() < b.back();
}
```

## 참고

BaaaaaaaarkingDog 실전 알고리즘
