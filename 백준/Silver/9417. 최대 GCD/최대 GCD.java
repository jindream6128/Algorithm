import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    //gcd 메서드를 통해서 최대공약수 찾기
    static int gcd(int a, int b){
        int tmp;

        if(a<b){tmp = b; b=a;a=tmp;}
        while(a%b>0){
            //a%b!=0
            tmp =b;
            b = a%b;
            a = tmp;
        }
        return b;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrlist = new ArrayList();

        for(int i = 0 ; i <n;i++){
            arrlist.clear();
            //한줄씩 받은걸 공백을 기준으로 전부 리스트에 넣는다
            String[] strarr = br.readLine().split(" ");

            for(int j = 0; j<strarr.length;j++){
                arrlist.add(Integer.parseInt(strarr[j]));
            }
            int max = 1;
            //모든쌍을 전부 돌아야 한다
            for(int j = 0;j<strarr.length-1;j++) {
                for (int k = j + 1; k < strarr.length; k++) {
                    int temp;
                    temp = gcd(arrlist.get(j), arrlist.get(k));
                    if (max < temp) {
                        max = temp;
                    }
                }
            }
            System.out.println(max);
        }
    }
}
