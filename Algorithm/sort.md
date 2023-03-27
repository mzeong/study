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

## 참고

BaaaaaaaarkingDog 실전 알고리즘
