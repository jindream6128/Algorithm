import sys
from collections import deque

input = sys.stdin.readline # 빠른 입력
print = sys.stdout.write # 빠른 출력, 출력은 반드시 문자열로

# 도시의 수 N
# 여행 계획에 속한 도시 수 M
# 1 연결 0 연결X
'''
0 1 0
1 0 1
0 1 0

=> 1-2 연결 2-1 연결 2-3 연결  3-2 연결
1-2-3 가기위해선

1-2-3
'''
def bfs(start, end):
    q =deque()
    q.append(start)
    v = [False] * N
    v[start] = True
    while q:
        now = q.popleft()

        if now == end:
            return True

        for i in range(N):
            # 시작 - 끝 연결 되어있고, 방문하지 않았을때
            if city[now][i] == 1 and not v[i]:
                v[i] = True
                q.append(i)
    return False

N = int(input())
M = int(input())

city = []

for i in range(N) :
    city.append(list(map(int,input().split())))

plan = list(map(int,input().split()))

ans = True

for i in range(M-1):
    #연속된 두도시가 같은경우 이동할 필요 없음
    if plan[i] != plan[i+1]:
        if not bfs(plan[i]-1, plan[i+1] -1): #연결되어있지않으면 false ! -> true
            ans = False
            break


if ans:
    print(str("YES")+'\n')
else:
    print(str("NO")+'\n')