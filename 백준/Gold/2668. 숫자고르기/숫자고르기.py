import sys
input = sys.stdin.readline # 빠른 입력
print = sys.stdout.write # 빠른 출력, 출력은 반드시 문자열로

# 첫째줄에서 뽑은 숫자와
# 둘째줄에 있는 숫자의 집합이 일치 -> 최대값

N = int(input())
graph = [[] for _ in range(N+1)]

for i in range(N):
    b = int(input())
    graph[b].append(i+1) #1부터 시작하도록

v = [False] * (N +1) #방문 여부
ans = [] #결과 집합

def dfs(node,target):
    target.add(node)
    v[node] = True #방문으로 바꾸기
    for i in graph[node]:
        if i not in target: #방문하지 않았다.
            #얕은 복사 -> 원래의 집합과 동일한 주소 -> 같은 배열을 사용하고 있다.
            dfs(i,target.copy())
        else:
            ans.extend(list(target)) #리스트 에 요소들 밀어넣기
            return

for i in range(1, N+1):
    if not v[i]: #방문한 적이 없을때 -> 결국 첫번째 뽑은 숫자는 다 돌아야함
        dfs(i,set([]))

ans.sort()

print(str(len(ans)) + '\n')
for i in ans:
    print(str(i) + '\n')