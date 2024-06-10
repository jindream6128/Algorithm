import sys
import heapq

input = sys.stdin.readline # 빠른 입력
print = sys.stdout.write # 빠른 출력 출력은 반드시 문자열로

n = int(input())
cls = [] # 수업들 입력

for i in range(n):
    start, end = map(int, input().split())
    cls.append((start, end))

cls.sort() # 시작 시간 기준으로 정렬

# 종료 시간을 저장할 최소 힙 (우선순위 큐)
heap = []

# 첫 번째 회의의 종료 시간을 힙에 추가
heapq.heappush(heap, cls[0][1])

for i in range(1, n):
    start, end = cls[i]
    # 가장 빨리 끝나는 회의의 종료 시간보다 현재 회의의 시작 시간이 크거나 같다면 회의실을 재사용
    if heap[0] <= start:
        heapq.heappop(heap) # 회의실 회수
    heapq.heappush(heap, end) # 새로운 종료 시간을 힙에 추가

# 힙의 크기가 필요한 회의실의 수
print(str(len(heap)))