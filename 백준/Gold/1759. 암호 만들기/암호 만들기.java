
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    //l개 선택
    static int l;
    //전체 c개
    static int c;
    //사용될 알파벳 -> 이거를 정렬하고 조합
    static char[] alpa;
    //저장될 arr
    static char[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[l];
        alpa = new char[c];

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<c;i++){
            alpa[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alpa);

        recur(0,0);
        System.out.println(sb);
        br.close();
    }

    static void recur(int start, int cur) throws IOException{
        if(cur == l){
            if(isVowelCheck(arr)>=1 && isConsonantCheck(arr)>=2){
                for(char chr : arr){
                    sb.append(chr);
                }
                sb.append("\n");
            }

            return;
        }


        for(int i = start; i<c;i++){
            arr[cur] = alpa[i];
            recur(i+1,cur+1);
        }
    }

    static int isVowelCheck(char[] arr){
        int chk = 0;
        for(char chr : arr){
            if(chr == 'a'||chr == 'e' || chr=='i'||chr=='o'||chr=='u'){
                chk++;
            }
        }
        return chk;
    }

    static int isConsonantCheck(char[] arr){
        int chk = 0;
        for(char chr : arr){
            if(chr == 'a'||chr == 'e' || chr=='i'||chr=='o'||chr=='u'){
            }else{
                chk++;
            }
        }
        return chk;
    }

}
