N = int(input()) # 0<= N <=99
count = 0
num = N

while True:
    a= num//10 #몫
    b= num%10 #나머지
    c = (a+b)%10 #오른쪽 끝숫자
    num = (10*b)+c
    count=count+1

    if (num==N):
        break

print(count)