
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        //tc갯수
        int tc = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i<tc;i++){
            st = new StringTokenizer(br.readLine());
            // 연속하는 부분 수열의 합이 d 로 나누어 떨어진다, 수열의 크기 n

            long d = Long.parseLong(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            long[] arr = new long[n+1];
            long[] prefix = new  long[n+1];
            long ans = 0;
            for(int j =1;j<n+1;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for(int j =1 ; j<n+1;j++){
                prefix[j]=prefix[j-1]+arr[j];
                //prefix가 나누어서 떨어지면 -> 연속하는 수열의 합이 d와 나누어 떨어지는거
                if(prefix[j]%d == 0){
                    ans++;
                }
            }

            Map<Long,Long> map = new TreeMap<>();
            for(int j =1; j<n+1;j++){
                long tmp = prefix[j]%d;
                // 나누어떨어질수 있는값이 존재한다면
                if(map.containsKey(tmp)){
                    ans += map.get(tmp);
                }
                //0L주의
                map.put(tmp,map.getOrDefault(tmp, 0L)+1);
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
