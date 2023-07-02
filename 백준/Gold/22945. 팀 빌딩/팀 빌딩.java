
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //개발자 수 n
        int n = Integer.parseInt(br.readLine());

        //개발자의 능력치를 저장할 길이가 n인 배열;
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //r은 끝에서 시작한다.
        int l=0,r=n-1,ans=0;

        while(true){
            int nummin = Math.min(arr[l],arr[r]);
            ans = Math.max(((r-l-1)*nummin),ans);
            if(arr[l]<arr[r]){
                //더 작은거를 가리키는 l
                l++;
            }
            else{
                //arr[r]이 더 작을땐 r을 움직인다.
                r--;
            }

            if(r<=l){
                break;
            }
        }
        System.out.println(ans);

        br.close();
    }
}
