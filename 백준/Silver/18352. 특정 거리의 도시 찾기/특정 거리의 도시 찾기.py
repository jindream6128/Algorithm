import sys
from collections import deque

input = sys.stdin.readline # 빠른 입력
print = sys.stdout.write # 빠른 출력, 출력은 반드시 문자열로

#N 도시의 갯수, M 도로의 갯수, K거리정보, 출발 도시 X
N,M,K,X = map(int,input().split())

#N+1개의 노드를 갖는 그래프
graph = [[] for i in range(N+1)]

for i in range(M): #도로
    a,b = map(int,input().split())
    graph[a].append(b)

d = [-1]*(N+1) #각 노드간의 거리 초기화
d[X] = 0 #시작노드 0

q = deque([X]) #시작노드
while q:
    start = q.popleft()# 현재노드 뽑기

    for nx in graph[start]: #갈수잇는 모든곳 탐색
        if d[nx]==-1: #방문X
            d[nx]=d[start]+1 #방문
            q.append(nx)

flag = False #k거리에 도시가 있는지 구분

for i in range(1,N+1):
    if d[i]==K:
        print(str(i)+'\n')
        flag = True #있다

if flag==False:
    print(str(-1))