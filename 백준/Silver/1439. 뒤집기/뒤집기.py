# 0 -> 1 로 바뀌는 케이스
# 1 -> 0 으로 바뀌는 케이스가 1개의 세트이다
# 숫자가 바뀌는걸 체크하고 //2 해주기
#### 010101 -> 3번
#### 010100 -> 2번

s = input()
cnt = 0
pre_s = ''
for i in s:
    if pre_s != i:
        cnt += 1
    pre_s = i

print(cnt // 2)
