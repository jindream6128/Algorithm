import java.io.*;
import java.util.*;

public class Main {
    //일단 들어가는 숫자는 0 ~ 9 10개이고
    //부등호숫자 +1 만큼 정답배열이 만들어 져야 한다.

    //부등호 갯수
    static int n;
    //각 숫자가 썼는지 안썼는지확인하기
    static boolean[] visited = new boolean[10];
    //부등호 들어갈 배열
    static char example[];
    //정답 확인에 쓸 배열
    static int arr[];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<String> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        example = new char[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i<n;i++){
            example[i] = st.nextToken().charAt(0);
        }

        recur(0);
        System.out.println(ans.get(ans.size() -1 ));
        System.out.println(ans.get(0));
        br.close();
    }
    static boolean check(int cur){
        if(cur<=1){
            return true;
        }
        //앞에서 틀렸으면 확인할 필요없음
        if( example[cur-2] == '<' && arr[cur-2] > arr[cur-1]){
            return false;
        }
        if( example[cur-2] == '>' && arr[cur-2] < arr[cur-1]){
            return false;
        }
        return true;
    }

    static void recur(int cur) {
        if(!check(cur)){
            return;
        }

        if(cur == n+1) {
            StringBuilder sb = new StringBuilder();
            for (int num : arr) {
                sb.append(num).append("");
            }
            ans.add(sb.toString());
            return;
        }


        for(int i = 0 ;i < 10;i++){
            if(visited[i]){
                continue;
            }

            arr[cur] = i;
            visited[i] = true;
            recur(cur+1);
            visited[i] = false;
        }

    }
}