

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        for(int i = 0 ; i<k ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        //오름차순 정렬
        Arrays.sort(arr);
        // 457 539 743 802 11개
        long e = arr[k-1];
        long s = 1;
        long ans=0 ;
        while(s <= e){
            long mid = (e+s)/2;

            long cnt = 0;
            for(int i = 0; i<k; i++){
                cnt += (arr[i]/mid);
            }

            if(cnt>=n){
                ans = mid;
                s = mid+1;
            }else{
                e = mid-1;
            }

        }

        System.out.println(ans);
        br.close();
    }
}
