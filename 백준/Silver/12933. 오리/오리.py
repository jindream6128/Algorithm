import sys
input = sys.stdin.readline # 빠른 입력
print = sys.stdout.write # 빠른 출력, 출력은 반드시 문자열로

duck = input().rstrip()  # 입력에서 개행 문자 제거
word = ['q', 'u', 'a', 'c', 'k']

if len(duck) % 5 != 0:
    print(str(-1) + "\n")
else:
    visited = [False] * len(duck)
    cnt = 0

    for a in range(len(duck)):
        if duck[a] == 'q' and not visited[a]:
            first = True
            index = 0
            for i in range(len(duck)):
                if word[index] == duck[i] and not visited[i]:
                    visited[i] = True
                    if duck[i] == 'k':
                        if first:
                            cnt += 1
                            first = False
                        index = 0
                        continue
                    index += 1

    if cnt == 0 or not all(visited):
        print(str(-1) + "\n")
    else:
        print(str(cnt) + "\n")
