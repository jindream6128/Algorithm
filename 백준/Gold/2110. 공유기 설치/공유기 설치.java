
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //총 집의 수
        int n = Integer.parseInt(st.nextToken());
        //공유기의 갯수
        int c = Integer.parseInt(st.nextToken());

        //집이 올라가있는 좌표
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int start = 1;
        int end = arr[n - 1] - arr[0] + 1;
        int ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            //mid 거리에서 공유기를 C개보다 설치를 못한다면 end값을 줄여서 거리를 좁혀준다
            //C 개 이상 설치를 한다면 start 값을 늘려서 공유기사이의 거리를 늘려준다.
            if (NumInstall(mid) < c) {
                end = mid -1;
            } else {
                start = mid +1;
                ans = mid;
            }

        }
        System.out.println(ans);


        br.close();
    }

    //distance에 대하여 설치가 가능한 공유기 의 수
    static int NumInstall(int distance) {
        //1번집엔 하나 설치
        int tmpHouse = arr[0];
        int cnt = 1;

        //제일처음 집에 설치가 되었다고 가정했으니까 2번째 집부터 돈다
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - tmpHouse >= distance) {
                cnt++;
                tmpHouse = arr[i];
            }
        }
        return cnt;
    }
}
