
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //n개 자연수
    static int n ;
    //m개 고르기
    static int len;
    static int[] arr;
    static int[] num;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());
        arr = new int[len];
        num = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        recur(0);
        System.out.println(sb);
        br.close();
    }
    static void recur(int cur){
        if(cur == len) {
            for(int num : arr){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i =0;i<n;i++){
            arr[cur] = num[i];
            recur(cur+1);
        }
    }
}
