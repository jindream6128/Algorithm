

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Boolean[][] arr;
    static int ans = 65;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //m은 세로
        int m = Integer.parseInt(st.nextToken());
        //n은 가로
        int n = Integer.parseInt(st.nextToken());
        arr = new Boolean[m][n];

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == 'W') {
                    arr[i][j] = true;
                }else{
                    arr[i][j] = false;
                }
            }
        }

        System.out.println(check(m, n));

        br.close();
    }

    //최솟값을 찾아주는 함수
    static int check(int m, int n) {

        for (int i = 0; i < m - 7; i++) {
            for (int j = 0; j < n - 7; j++) {
                Boolean tmp = arr[i][j];
                int cnt = 0;

                for (int next_x = i; next_x < i + 8; next_x++) {
                    for (int next_y = j; next_y < j + 8; next_y++) {
                        if (arr[next_x][next_y] != tmp) {
                            cnt++;
                        }
                        tmp = (!tmp);
                    }
                    //다음줄은 서로 반대로 시작
                    tmp = (!tmp);
                }
                cnt = Math.min(cnt,64-cnt);
                ans = Math.min(ans, cnt);
            }
        }

        return ans;
    }

}
