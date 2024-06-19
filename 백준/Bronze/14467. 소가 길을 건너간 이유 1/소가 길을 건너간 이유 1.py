# 소는 최대 1~10 총 11마리 들어올수있다
# 각위치 저장해놓고 바뀐 횟수만 세어보자

import sys
input = sys.stdin.readline #빠른 입력
print = sys.stdout.write #빠른 출력 출력은 반드시 문자열로

cow = [-1]*10 #-1 은 가지고 있지 않는 소
ans = 0
n = int(input())
for _ in range (n):
    a,b = map(int,input().split())
    if cow[a-1] == -1:
        cow[a-1] = b
    elif cow[a-1] != b:
        cow[a-1] = b
        ans += 1
print(str(ans))