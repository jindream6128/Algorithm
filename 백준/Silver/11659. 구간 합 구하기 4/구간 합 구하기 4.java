
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.IntToDoubleFunction;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] prefix = new int[n + 1];
        prefix[0] = 0;

        st = new StringTokenizer(br.readLine());
        //prefix 만들기
        for(int i = 1;i<n+1;i++){
            prefix[i] = prefix[i-1]+Integer.parseInt(st.nextToken());
        }

        for(int tc = 0; tc<m; tc++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(prefix[j]-prefix[i-1]);
        }
        br.close();
    }
}
