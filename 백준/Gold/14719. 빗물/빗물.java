
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken()); // 높이
        int w = Integer.parseInt(st.nextToken()); // 가로 최대
        int[] arr = new int[w + 1];
        int prefixsum = 0;
        int suffixsum = 0;

        st = new StringTokenizer(br.readLine()); //블록의 길이 입력받기
        for(int i =1; i<w+1;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //물이 받아지기 위해서는 1. 제일 처음과 제일마지막에는 받아질수 없다.
        //2. 두번째 블록부터 돌며, 왼쪽이랑 오른쪽에 자기보다 더 높은 블록이 모두 존재해야 한다.
        //3. 두불럭이 모두 존재할때 두 블럭의 최솟값에서 현재 값을 빼고 저장한다.

        int ans = 0;
        //처음과 마지막은 물이 받아질수 없다.
        for(int i = 2; i<w;i++){
            int tmp = arr[i];
            //2. 두번째 블록부터 돌며 왼쪽이랑 오른쪽에 자기보다 높은 블럭 확인하기.
            //왼쪽 최대 저장하기.
            int leftmax = 0;
            for(int j = 1; j<i;j++){
                leftmax = Math.max(leftmax, arr[j]);
            }
            //오른쪽 최대 저장하기
            int rightmax =0;
            for(int j = w; i<j ;j--){
                rightmax = Math.max(rightmax, arr[j]);
            }

            //3. 두블럭 모두 존재할때 두블록의 최솟값 - 현재값을 더해준다
            // 두블럭이 모두 존재한다-> leftmax랑 rightmax값중 최솟값이 tmp값 즉 측정할려는 값 보다 크면 된다
            if(Math.min(rightmax,leftmax) > tmp){
                ans += Math.min(rightmax, leftmax) - arr[i];
            }
        }

        System.out.println(ans);
        br.close();
    }
}
