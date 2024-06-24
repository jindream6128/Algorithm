import sys
input = sys.stdin.readline # 빠른 입력
print = sys.stdout.write # 빠른 출력, 출력은 반드시 문자열로

inValue = input().split('-')
ans =0

for i in inValue[0].split('+'):
    ans += int(i)

for i in inValue[1:]:
    for j in i.split('+'):
        ans -= int(j)

print(str(ans))
