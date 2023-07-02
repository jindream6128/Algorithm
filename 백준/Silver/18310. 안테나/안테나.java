import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i =0; i<N; i++){
            arr.add(Integer.valueOf(st.nextToken()));
        }
        //arr 정렬
        Collections.sort(arr);
        if(N%2 == 0){
        bw.write(String.valueOf(arr.get((N-1)/2)));
        }else if(N%2 != 0){
            bw.write(String.valueOf(arr.get(N/2)));
        }

        bw.close();
        br.close();
    }
}
