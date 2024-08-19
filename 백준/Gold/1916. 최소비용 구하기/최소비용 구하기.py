import heapq
import sys

input = sys.stdin.readline # 빠른 입력
print = sys.stdout.write # 빠른 출력, 출력은 반드시 문자열로

#N 도시의 갯수, M 버스의 갯수
#입력 a->b c비용

INF = sys.maxsize
n = int(input())
m = int(input())

graph = [[] for i in range(n+1)]


for i in range(m):
    a,b,c = map(int, input().split())
    #a ->b 비용 c
    graph[a].append((b,c))

#목적지
start, end = map(int, input().split())

def dijkstra(graph, start):
    dis = [INF] * (n+1)
    dis[start] = 0 #시작점
    queue = []
    heapq.heappush(queue, [dis[start],start]) #시작노드부터 탐색

    while queue: # 갈수있는 곳이 있을때
        distance, node = heapq.heappop(queue) #거리, 다음 탐색 노드

        #최단거리보다 멀면 continue
        if dis[node] < distance:
            continue

        #최단거리보다 가까우면 그 다음 노드 탐색
        for next_node, next_distance in graph[node]:
            sum_distance = distance + next_distance # 온 거리 + 다음 거리
            if sum_distance < dis[next_node]: #기존 거리보다 짧으면 갱산
                dis[next_node] = sum_distance
                heapq.heappush(queue,[sum_distance,next_node]) #다음 거리를 계산하기 위해 다시 큐에 삽입

    #전체 방문 후
    return dis

#갱신 후 배열
ans = dijkstra(graph,start)
print(str(ans[end]))