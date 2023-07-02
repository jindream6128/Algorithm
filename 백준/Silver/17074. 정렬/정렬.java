
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int decline = 0;
        int tmp = 0;
        int c = 0;
        int n =Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n-1; i++) {
            if (arr[i] > arr[i + 1]) {
                tmp = i;
                decline++;
            }
        }

        switch (decline){
            case 0:
                System.out.println(n);
                break;

            case 1:
                if(tmp == n-2){
                    if(arr[tmp-1] <= arr[tmp+1])
                        System.out.println("2");
                    else
                        System.out.println("1");
                }
                else if(tmp == 0){
                    if(arr[tmp] <= arr[tmp+2])
                        System.out.println("2");
                    else
                        System.out.println("1");
                }
                else{
                    if(arr[tmp-1] <= arr[tmp+1])
                        c++;
                    if(arr[tmp] <= arr[tmp+2])
                        c++;
                    System.out.println(c);
                }
                break;

            default:
                System.out.println("0");
                break;
        }
        br.close();
    }

}
