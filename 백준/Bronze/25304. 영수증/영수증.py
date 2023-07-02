X = int(input()) #물건의 총 금액
N = int(input()) #물건의 종류 수
sum = 0

for i in range(1,N+1):
    a, b = map(int, input().split()) # a,b 각 물건의 가격 a , 갯수 b
    sum += a*b
    
if X == sum:
    print("Yes")
else:
    print("No")