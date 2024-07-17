import sys
input = sys.stdin.readline # 빠른 입력
print = sys.stdout.write # 빠른 출력, 출력은 반드시 문자열로

def binary_search(blueRay,arr):
    s = max(lecture)
    e = sum(lecture)
    ans = 0
    while s<=e:
        mid = (s+e)//2

        lecture_len = 0
        cnt = 1
        for i in arr:
            if lecture_len + i > mid:
                cnt += 1 #  1개의 블루레이 사용
                lecture_len=0

            lecture_len += i

        if cnt <= blueRay:
            e = mid-1
            ans = mid
        else: # cnt > bluRay
            s = mid+1
    return ans


N, M = map(int, input().split())#강의수N M개의 블루레이
lecture = list(map(int, input().split())) #강의 길이
# lecture.sort()

# 전부다 1개씩 들어갈때 -> max(lecture)
# 전부다 1개에 들어갈때 -> sum(lecture)

ans = binary_search(M,lecture)
print(str(ans) + '\n')