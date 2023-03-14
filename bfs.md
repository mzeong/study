## BFS

방문 표시를 남기기 때문에 모든 칸은 큐에 1번씩만 들어가게 된다. 그렇기 때문에 시간복잡도는 칸이 N개일 때 O(N)이 된다. 만약 행이 R개이고 열이 C개이면 O(RC)가 될 것이다.

```
#define X first
#define Y second
int dy[4] = {0, 1, 0, -1};
int dx[4] = {1, 0, -1, 0};

void bfs(int y, int x) {
  queue<pair<int,int>> Q;
  vis[y][x] = 1;
  Q.push({y, x});
  while(!Q.empty()){
    auto cur = Q.front(); Q.pop();
    for(int i = 0; i < 4; i++){
    	int ny = cur.Y + dy[i];
	int nx = cur.X + dx[i];
	if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
	if(vis[ny][nx] || board[ny][nx]) continue;
	vis[ny][nx] = 1; 
	Q.push({ny,nx});
    }
  }
}
```

1. 시작점에 방문했다는 표시를 남기지 않으면 시작점을 두 번 방문할 수 있다.
2. 큐에 넣을 때가 아닌 빼낼 때 방문 표시를 남기면 시간 초과나 메모리 초과가 발생할 수 있다.
3. 범위 체크를 빼먹지 말 것 

### 응용

1. 거리 측정
2. 시작점이 여러 개일 때
    
    해결법은 의외로 간단한데, 그냥 모든 시작점을 큐에 넣고 앞에서 한 것과 똑같이 BFS를 돌면 끝
    
3. 시작점이 두 종류일 때
    
    각각의 BFS를 따로 돌려서 해결 
    
    만약 BFS를 돌 때 어느 하나가 독립적이지 않고 서로에게 영향을 준다면 단순히 따로 돌려서는 해결할 수 없다. 그런 상황에서는 시간순으로 A와 B를 동시에 진행시켜야 한다.
    
4. 1차원에서의 BFS
    
    

## 참고

BaaaaaaaarkingDog 실전 알고리즘
