
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringTokenizer st2;

        Map<Long, Integer> map = new TreeMap<>();
        map.put(0L, 1);
        long ans = 0;
        long before = 0;

        st = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            before += Integer.parseInt(st.nextToken()) - Integer.parseInt(st2.nextToken());

            if (map.containsKey(before)) {
                ans += map.get(before);
                map.put(before, map.get(before) + 1);
            }
            else{
                map.put(before,1);
            }
        }
        System.out.println(ans);

    }
}
