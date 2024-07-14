import sys
input = sys.stdin.readline # 빠른 입력
print = sys.stdout.write # 빠른 출력, 출력은 반드시 문자열로

"""
6 3 2 10 10 10 -10 -10 7 3 target 3
-10 -10 2 3 3 6 7 10 10 10
"""
# 갯수로 세면 안되고, 왼쪽에서 처음 등작하는 index
# 오른쪽에서 처음 등장하는 index 를 구해서 빼줘야한다
def binary_search_left(target, arr):
    start = 0
    end = len(arr) - 1
    while start <= end:
        mid = (start + end) // 2
        if arr[mid] < target: #같은거는 끝
            start = mid + 1
        else:
            end = mid - 1
    return start
def binary_search_right(target, arr):
    start = 0
    end = len(arr) - 1
    while start <= end:
        mid = (start + end) // 2
        if arr[mid] <= target:  #마지막 값을 찾기위해서
            start = mid + 1
        else:
            end = mid - 1
    return start

N = int(input())
arr = list(map(int, input().split()))
arr.sort() #이진탐색을 위한 정렬
M = int(input())
target_arr = list(map(int, input().split())) #찾아야하는 값들

for i in target_arr:
    right = binary_search_right(i, arr)
    left = binary_search_left(i, arr)
    cnt = right-left
    print(str(cnt) + " ")
