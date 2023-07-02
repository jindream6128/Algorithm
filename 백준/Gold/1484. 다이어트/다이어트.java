
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //G 킬로그램
        long g = Integer.parseInt(br.readLine());

        long now =1;
        long before =1;
        while(now<=50_000){
            if(((now*now)-(before*before))==g){
                sb.append(now).append("\n");
                before++;
                now++;
            }

            if(((now*now)-(before*before))<g){
                now++;
            }else{
                before++;
            }
        }
        if(sb.length()==0){
            sb.append(-1);
        }

        System.out.println(sb);
        br.close();
    }
}
