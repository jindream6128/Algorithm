

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SimpleTimeZone;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //벨트에 놓인 초밥갯수 n
        int n = Integer.parseInt(st.nextToken());
        //초밥의 가짓수 d
        int d = Integer.parseInt(st.nextToken());
        //연속해서 먹는 초밥의 갯수
        int k = Integer.parseInt(st.nextToken());
        //쿠폰 번호
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] type = new int[d + 1];
        //쿠폰 번호에 적힌 초밥은 1카운터
        type[c]++;

        //무조건 1개 이상 (쿠폰)
        int cnt = 1;
        int l = 0;
        int r = l+k-1;
        int ans = 0;

        //제일 앞에 k만큼의 갯수를 세어보고 몇개의 종류가 사용되었는지 먼저 확인한다.
        for (int i = 0; i < k; i++) {
            type[arr[i]]++;
            //한번도 안쓰인거라면 cnt +1
            if (type[arr[i]] == 1) {
                cnt++;
            }
        }

        //이건 l과 r이 동시에 움직여야 한다-> k가 연속해서 4개라고 했으니까
        //그리고 한칸씩 밀어본다.
        while (l<n) {

            type[arr[l]]--;
            if(type[arr[l]] == 0){
                cnt--;
            }
            l++;

            r = (l+k-1)%n;
            type[arr[r]]++;
            if(type[arr[r]]==1){
                cnt++;
            }

            ans = Math.max(cnt,ans);
        }

        System.out.println(ans);
        br.close();
    }
}
