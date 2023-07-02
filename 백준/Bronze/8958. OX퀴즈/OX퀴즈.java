
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int i =0;i<tc;i++){
            String s = br.readLine();
            int sum=0;
            int cnt =1;
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='O'){
                    sum+=cnt;
                    cnt++;
                }else if(s.charAt(j)=='X'){
                    cnt =1;
                }
            }
            System.out.println(sum);
        }

        br.close();
    }
}
