import sys

input = sys.stdin.readline # 빠른 입력
print = sys.stdout.write # 빠른 출력, 출력은 반드시 문자열로

# V개 마을, E개 도로
# 각도로 들의 정보 a b c   a번 마을 -> b번 마을로가는 거리 c
V,E = map(int,input().split())
INF = sys.maxsize
graph = list(list(INF for _ in range(V+1)) for _ in range(V+1))

for _ in range (E):
    a,b,c = map(int,input().split())
    graph[a][b] = c

for i in range (1,V+1):
    for j in range(1,V+1):
        for k in range(1,V+1):
            graph[j][k] = min(graph[j][k],graph[j][i]+graph[i][k])

ans = INF
for i in range(1,V+1):
    ans = min(ans, graph[i][i])

if ans == INF:
    print (str(-1))
else:
    print(str(ans))