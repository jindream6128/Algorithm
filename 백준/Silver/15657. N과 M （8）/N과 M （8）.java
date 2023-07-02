
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int len;
    static int[] arr;
    static int[] num;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

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

        recur(0,0);
        System.out.println(sb);
        br.close();
    }

    static void recur(int start, int cur){
        if(cur == len){
            for(int num : arr){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i =start; i<n;i++){
            arr[cur] = num[i];
            recur(i,cur+1);
        }
    }
}
