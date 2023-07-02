
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        //모두 대문자로
        s= s.toUpperCase();
        //모든 알파벳 26개 ABCDEFGHIJKLMNOPQRSTUVWXYZ -> A부터 아스키코드로 65 부터 90
        //-65를 해서 0~25로 맞춰준다
        int[] alpanum = new int[26];
        for(int i =0;i < s.length();i++){
            int tmp = s.charAt(i)-65;
            alpanum[tmp] += 1;
        }

        int max = 0;
        char ans = '?';
        for(int i =0;i<26;i++){
            if(max<alpanum[i]){
                max = alpanum[i];
                //다시 대문자로 바꿔준다
                ans = (char)(i+65);
                //max가 두개 존재할때
            }else if(alpanum[i]==max){
                 ans = '?';
            }
        }
        System.out.println(ans);



        br.close();
    }
}
