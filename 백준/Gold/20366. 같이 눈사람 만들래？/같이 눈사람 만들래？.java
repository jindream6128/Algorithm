import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //눈덩이 갯수
        int n = Integer.parseInt(br.readLine());
        //지름이 Hi인 눈덩이 N개 입력
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //오름차순 정렬
        Arrays.sort(arr);

        int start;
        int end;
        int ans = Integer.MAX_VALUE;

        //항상 시작점과 끝점 사이에는 2개이상의 눈덩이가 있어야 한다.
        for (start = 0; start < n - 3; start++) {
            for (end = start + 3; end < n; end++) {
                int l = start + 1;
                int r = end - 1;
                while (true) {
                    //멈추는 조건
                    if (l >= r) {
                        break;
                    }

                    int tmp = (arr[start] + arr[end]) - (arr[l] + arr[r]);

                    if (ans > Math.abs(tmp)) {
                        ans = Math.abs(tmp);
                    }

                    //r값 줄이기
                    if (tmp < 0) {
                        r--;
                    } else {
                        l++;
                    }

                }

            }
        }

        System.out.println(ans);
        br.close();
    }
}
