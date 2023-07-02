
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //1부터 n까지
    static int n;

    //길이 m
    static int len;

    static int[] arr;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());

        //정답이 저장될 arr
        arr = new int[len];
        //start 1부터 조심
        recur(1,0);
        System.out.println(sb);
        br.close();
    }

    static void recur(int start, int cur){
        if (cur == len){
            for(int num : arr){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i =start; i<=n;i++){
            arr[cur] =i;
            recur(i+1, cur+1);
        }

    }
}
