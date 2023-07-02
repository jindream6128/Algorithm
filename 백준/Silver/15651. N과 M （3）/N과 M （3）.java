
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //1부터n
    static int n;
    //몇개 고르는길이 m
    static int len;
    static int[] arr;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());
        arr = new int[len];

        recur(0);
        System.out.println(sb);
        br.close();
    }
    static void recur(int cur){
        if(cur == len){
            for(int num : arr){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i =1; i<=n; i++){
            arr[cur] = i;
            recur(cur+1);
        }
    }
}
