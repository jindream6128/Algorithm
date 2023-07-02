
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //수열의 길이 n , 최대 삭제 가능한 횟수 k
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 1;
        int r = 1;
        int ans = 0;
        int cnt = 0;
        while (r <= n) {
            //cnt가 k만큼 안뺐을때
            if (cnt < k) {
                //홀수
                if ((arr[r] % 2) != 0) {
                    cnt++;
                }
                //짝수
                r++;
                //최대 길이 업데이트
                ans = Math.max(r - l - cnt, ans);
            } //짝수일때  
            else if ((arr[r] % 2) == 0) {
                r++;
                ans = Math.max(r - l - cnt, ans);
            } else {
                //시작 점이 홀수 였었으면 cnt 는 빼준다든다.
                if ((arr[l] % 2) != 0) {
                    cnt--;
                }
                //홀수가 아니라면 그냥 시작점 한칸 밀어주기
                l++;

            }
        }

        System.out.println(ans);
        br.close();
    }
}
