## 배열 vs 연결 리스트

|  | 배열 | 연결 리스트 |
| --- | --- | --- |
| k번째 원소의 접근 | O(1) | O(k) |
| 임의 위치에 원소 추가/제거 | O(N) | O(1) |
| 메모리 상의 배치 | 연속 | 불연속 |
| 추가적으로 필요한 공간 
(Overhead) | - | O(N) |

배열은 데이터만 저장하면 되지만, 연결 리스트는 각 원소가 다음 원소, 혹은 이전과 다음 원소의 주소값을 가지고 있어야 한다. 

배열과 연결 리스트는 원소들 사이의 선후 관계가 일대일로 정의되어(첫 번째 원소, 두 번째 원소, …)  선형 자료구조라고 불린다. 트리, 그래프, 해시 등은 비선형 자료구조의 대표적인 예시이다. 

## 야매 연결 리스트

```
const int MX = 1000005;
int dat[MX], pre[MX], nxt[MX];
int unused = 1;

fill(pre, pre+MX, -1);
fill(nxt, nxt+MX, -1);
```

```
void traverse() {
	int cur = nxt[0];
	while (cur != -1) {
		cout << dat[cur] << " ";
		cur = nxt[cur];
	}
	cout << "\n\n";
}
```

### insert 함수

1. 새로운 원소를 생성
2. 새 원소의 pre 값에 삽입할 위치의 주소를 대입
3. 새 원소의 nxt 값에 삽입할 위치의 nxt 값을 대입
4. 삽입할 위치의 nxt 값과 삽입할 위치의 다음 원소의 pre 값을 새 원소로 변경
5. unused 1 증가

```
void insert(int addr, int num) {
	dat[unused] = num;
	pre[unused] = addr;
	nxt[unused] = nxt[addr];
	if (nxt[addr] != -1) pre[nxt[addr]] = unused;
	nxt[addr]= unused;
	unused++;
}
```

### erase 함수

1. 이전 위치의 nxt를 삭제할 위치의 nxt로 변경
2. 다음 위치의 pre를 삭제할 위치의 pre로 변경

```
void erase(int addr) {
	nxt[pre[addr]] = nxt[addr];
	if (nxt[addr] != -1) pre[nxt[addr]] = pre[addr];
}
```

## STL list

```
int main(void) {
	list<int> L = {1, 2};
	list<int>::iterator t = L.begin();  // t는 1을 가리키는 중
	L.push_front(10);    // 10 1 2
	cout << *t << "\n";  // t가 가리키는 값 = 1을 출력
	L.push_back(5);      // 10 1 2 5
	L.insert(t, 6);      // t가 가리키는 곳 앞에 6을 삽입, 10 6 1 2 5 
	t++;                 // 현재 t가 가리키는 값은 2
	t = L.erase(t);      // t가 가리키는 값을 제거, 그 다음 원소인 5의 위치를 반환
	cout << *t << "\n";  // 5
	for (auto i : L) cout << i << " ";
	cout << "\n";
	for (list<int>::iterator it = L.begin(); it != L.end(); it++)
		cout << *it << " ";
}
```

list::iterator라는 type을 치기가 귀찮으면 C++11 이상일 때 auto t = L.begin()으로 써도 된다.

야매 연결 리스트에서는 제알 앞의 원소를 더미 노드로 사용하지만 STL list에서는 제일 뒤의 원소가 더미 노드이다. 그래서 L.begin()은 제일 앞에 있는 원소를 가리키지만 **L.end()는 제일 뒤에 있는 원소의 한 칸 뒤를 가리킨다.** 

## 연습문제

- 원형 연결 리스트 내의 임의의 노드 하나가 주어졌을 때 해당 List의 길이를 효율적으로 구하는 방법?
    
    동일한 노드가 나올 때까지 계속 다음 노드로 간다. 공간복잡도 O(1), 시간복잡도 O(N)
    
- 중간에 만나는 두 연결 리스트의 시작점들이 주어졌을 때 만나는 지점을 구하는 방법?
    
    일단 두 시작점 각각에 대해 끝까지 진행시켜서 각각의 길이를 구한다. 그 후 다시 두 시작점으로 돌아와서 더 긴 쪽을 둘의 차이만큼 앞으로 먼저 이동시켜놓고 두 시작점이 만날 때까지 두 시작점을 동시에 한 칸씩 전진시킨다. 공간복잡도 O(1), 시간복잡도 O(A+B)
    
- 주어진 연결 리스트 안에 사이클이 있는지 판단하라
    
    Floyd’s cycle-finding algorithm, 한 칸씩 가는 커서와 두 칸씩 가는 커서를 동일한 시작점에서 출발시켰을 때 사이클이 있으면 두 커서는 반드시 만나게 된다. 만약 사이클이 없으면 두 커서가 만나지 못하고 연결 리스트의 끝에 도달한다. 공간복잡도 O(1), 시간복잡도 O(N)
    

## 참고

BaaaaaaaarkingDog 실전 알고리즘
