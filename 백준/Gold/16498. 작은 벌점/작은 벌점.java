
import java.util.*;
import java.io.*;

public class Main {
    static int Diff(int a, int b, int c){
        return Math.abs(Math.max(a,Math.max(b,c))-Math.min(a,Math.min(b,c)));
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arrA = new int[a];
        for(int i = 0; i< a; i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA);

        st = new StringTokenizer(br.readLine());
        int[] arrB = new int[b];
        for(int i =0;i<b; i++){
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrB);

        st = new StringTokenizer(br.readLine());
        int[] arrC = new int[c];
        for(int i = 0; i<c;i++){
            arrC[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrC);

        int ans = Integer.MAX_VALUE;
        for(int i =0; i<a;i++){
            for(int j = 0; j<b; j++){
                for(int k =0; k<c;k++){
                    int anum = arrA[i];
                    int bnum = arrB[j];
                    int cnum = arrC[k];
                    int minnum = Diff(anum,bnum,cnum);
                    ans = Math.min(minnum,ans);
                }
            }
        }

        System.out.println(ans);
        br.close();
    }
}
