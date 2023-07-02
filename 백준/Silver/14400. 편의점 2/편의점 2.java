import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        //최선이 되는 좌표
        int midx = 0;
        int midy = 0;
        //입력 받을 2차원 배열 생성
        int[][] arr = new int[n][2];

        for(int i = 0; i<n;i++){
            //공백을 단위로 문자열 읽어오기
            String[] s = br.readLine().split(" ");
            //정수로 바꿔서 각각의 좌표 저장
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            arr[i][0] = x;
            arr[i][1] = y;
        }

        //2차원 배열 정렬 -> 각각 좌표를 기준으로 정렬하고 중간값 mx, my 구하기
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            //compare o1, o2 비교해서
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        // 짝수더라도 그냥 가운데 범위내에 있으면 되므로 가운데값으로 지정
        midx = arr[n/2][0];

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        midy = arr[n/2][1];

        long ans = 0;
        for (int i=0; i<n;i++)
        {
            ans += Math.abs(midx - arr[i][0]) + Math.abs(midy - arr[i][1]);
        }
        bw.write(String.valueOf(ans));
        bw.close();
        br.close();
    }
}
