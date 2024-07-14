import sys
input = sys.stdin.readline # 빠른 입력
print = sys.stdout.write # 빠른 출력, 출력은 반드시 문자열로

def binary_search(value,arr):
    start = 0
    end = len(arr)-1 #끝점

    while start <= end:
        mid = (start + end) // 2 #중간 값
        if arr[mid] == value: #배열안에 들어있을때
            return 1
        elif arr[mid] < value:
            start = mid + 1
        else:   #arr[mid] > value
            end = mid - 1

    return 0    #전체돌아도 없으때

N = int(input())
A = list(map(int, input().split())) #정수
A.sort()    #이분탐색은 항상 정렬된 상태에서 시작
M = int(input())
find_arr = list(map(int, input().split())) # arr 값이 정수 안에 있는지 확인하기

for i in find_arr:
    print(str(binary_search(i,A))+'\n') # 찾는 값, 찾는 배열