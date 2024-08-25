import sys
from collections import deque

input = sys.stdin.readline # 빠른 입력
print = sys.stdout.write # 빠른 출력, 출력은 반드시 문자열로

#N,M

#A -> B A가 B를 신뢰한다

# 가장 많이 해킹할 수 있는 컴퓨터 번호 오름차순

def bfs(i):
    visited = [0] * (N + 1)
    q = deque([i])
    visited[i] = 1
    cnt = 1

    while q:
        x = q.popleft()

        for nx in com[x]:
            if not visited[nx]:
                q.append(nx)
                visited[nx] = 1
                cnt += 1

    return cnt


N, M = map(int, input().split())
com = [[] for _ in range(N+1)] #컴퓨터 번호 0제외


for _ in range(M):
    A,B = map(int, input().split())
    com[B].append(A)

ans = []
max_cnt = 0
for i in range(1,N+1):
    result = bfs(i)
    if max_cnt < result:
        max_cnt = result
        ans.clear()
        ans.append(i)
    elif max_cnt == result:
        ans.append(i)

for i in range(len(ans)):
    print(str(ans[i]) + ' ')