import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken()); //왼쪽 면의 위치
            int h = Integer.parseInt(st.nextToken()); //높이
            arr[l] = h;
        }
        //제일 높은 기둥 구하기
        int max = 0;
        int max_x = 0;
        for (int i = 0; i < 1001; i++) {
            if (max < arr[i]) {
                max = arr[i];
                max_x = i; //max의 l
            }
        }

        //왼쪽부터 찾기
        int max_left = 0;
        int sum_left = 0;
        for (int i = 0; i < max_x; i++) {
            if (max_left < arr[i]) {
                max_left = arr[i];
                sum_left += arr[i];
            } else if (max_left >= arr[i]) {
                sum_left += max_left;
            }
        }

        //오른쪽 부터 찾기
        int max_right = 0;
        int sum_right = 0;
        for (int i = 1000; i > max_x; i--) {
            if (max_right < arr[i]) {
                max_right = arr[i];
                sum_right += arr[i];
            } else if (max_right >= arr[i]) {
                sum_right += max_right;
            }
        }

        int result = sum_left + sum_right + max;
        
        bw.write(String.valueOf(result));
        
        bw.flush();
        br.close();
    }
}
