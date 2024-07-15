import sys
input = sys.stdin.readline # 빠른 입력
print = sys.stdout.write # 빠른 출력, 출력은 반드시 문자열로

#적어도 value 만큼은 가져 가야한다
def binary_search(value,arr):
    s, e = 0,arr[-1]  #최소, 최댓값

    while s<=e:
        mid = (s+e)//2
        total = 0
        for i in arr:
            if mid<i:
                total += i-mid

        if total < value:
            e = mid -1
        else: #total>=value
            s = mid+1

    return e

# 나무의 수 N, 집으로 가지고갈 최소한의나무 수 M
N, M = map(int, input().split())
# 나무 배열
tree_arr = list(map(int, input().split()))
tree_arr.sort()

print(str(binary_search(M, tree_arr)))
