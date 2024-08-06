import sys

input = sys.stdin.readline # 빠른 입력
print = sys.stdout.write # 빠른 출력, 출력은 반드시 문자열로

# N 지름길의 갯수 D 고속도로의 길이 a,b,c 시작위치, 도착위치, 지름길 길이

n,d = map(int,input().split())
graph = []
for _ in range(n):
    a,b,c = map(int,input().split())
    graph.append([a,b,c])

dist = [i for i in range(d+1)] #거리

for i in range(len(dist)):
    # 지름길이 있으면 지름길, 아니면 이전칸에서 한칸 뒤로
    dist[i] = min(dist[i],dist[i-1]+1)

    for start,end,short in graph:
        # 1. 시작점이 == 지름길
        # 2. 끝 안지나가기
        # 3. 거리 == 지름길 일때, 더짧은경우
        if start == i and end <= d and dist[i]+short < dist[end]:
            # 지름길을 지난 값으로 교체하기
            dist[end] = dist[i] +short

print(str(dist[d]))