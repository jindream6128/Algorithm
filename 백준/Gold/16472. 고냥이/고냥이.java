
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Parameter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //각자 알파벳 26개
        int[] alpaArr = new int[26];

        //알파벳 입력
        String s = br.readLine();

        //시작점, 끝점, 알파벳 종류의 갯수-> 처음꺼 반영하니까 cnt=1, 정답
        int l = 0, r = 0, cnt = 1, ans = 0;
        //'a'가 0일려면 첫번째에서 -'a'를 뺀값 -> 아스키코드
        alpaArr[s.charAt(0) - 'a'] = 1;

       while(true){
           r++;
           if(r==s.length()) break;

           //사용된적이 있으면 그냥 갯수만 올린다.
           alpaArr[s.charAt(r)-'a'] += 1;

           //사용된적이 없다, 위에서 1더해줬으니까 1일때는 사용된적이 없는거다.
           if(alpaArr[s.charAt(r)-'a'] == 1){
               cnt++;
           }

           while(cnt>n){
               //제일앞에 문자를빼고
               alpaArr[s.charAt(l) - 'a'] -= 1;
               //뺏을때 값이 0이면 이젠 아예 안쓰인다는거니까 cnt 값 자체를 바꾼다
               if(alpaArr[s.charAt(l) - 'a'] == 0){
                   cnt--;
               }
               //시작점 옮기기
               l++;
           }
           //어짜피 l이 제일 왼쪽이 제일크니까, r이 움직일때 마다 ans값 업데이트
           ans = Math.max(ans, r-l+1);

       }

        System.out.println(ans);

        br.close();
    }
}
