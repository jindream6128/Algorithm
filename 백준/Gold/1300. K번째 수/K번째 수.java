import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //배열 A의 크기 N*N
        int n = Integer.parseInt(br.readLine());
        //배열B[k] 의 k값
        int k = Integer.parseInt(br.readLine());

        int start = 1;
        int end = k;

        int ans = 0;

        while(start<= end) {
            int mid = (start + end)/2;
            int cnt = 0;
            for (int i = 1; i < n + 1; i++) {
                cnt += Math.min(n, mid/i);
            }

            if(cnt >= k){
                ans = mid;
                end = mid -1;
            }else{
                start = mid +1;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
