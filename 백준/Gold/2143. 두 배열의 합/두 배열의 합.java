
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long t = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        //배열 A의 갯수 1~n까지
        int n = Integer.parseInt(st.nextToken());
        //배열 A 입력받기
        long[] Aarr = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            Aarr[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        //배열 B의 갯수 1~m까지
        int m = Integer.parseInt(st.nextToken());
        //배열 B입력받기
        long[] Barr = new long[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < m + 1; i++) {
            Barr[i] = Long.parseLong(st.nextToken());
        }
        //각 원소의 절댓값은 1,000,000이다 최대 1,000개가 주어지더라도 10억이므로 Integer를 벗어나지 않는다.
        //-> 근데왜 오류가뜨고, Long으로 바꾸니까 잘 출력된다.. 어디선가 오버플로가 나오는거 같다.
        //각각 prefix 구하기
        long[] prefixA = new long[n + 1];
        long[] prefixB = new long[m + 1];
        for (int i = 1; i < n + 1; i++) {
            prefixA[i] = prefixA[i - 1] + Aarr[i];
        }
        for (int i = 1; i < m + 1; i++) {
            prefixB[i] = prefixB[i - 1] + Barr[i];
        }

        Map<Long, Long> sumA = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                sumA.computeIfPresent(prefixA[j] - prefixA[i], (k, v) -> v + 1);
                sumA.putIfAbsent(prefixA[j] - prefixA[i], 1L);
            }
        }

        Map<Long, Long> sumB = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j <= m; j++) {
                sumB.computeIfPresent(prefixB[j] - prefixB[i], (k, v) -> v + 1);
                sumB.putIfAbsent(prefixB[j] - prefixB[i], 1L);
            }
        }

        long ans = 0;
        for (Long key : sumA.keySet()) {
            if (sumB.containsKey(t - key)) {
                ans += sumA.get(key) * sumB.get(t - key);
            }
        }

        System.out.println(ans);
        br.close();
    }
}
