import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        str = str.toUpperCase();    //처음부터 모두 대문자로 저장

        //알파벳 저장 맵함수
        Map<Character,Integer> alpha = new HashMap<Character,Integer>();

        //알파벳 순회
        for(int i = 0; i <str.length();i++){
            char ch = str.charAt(i);

            //이미 가지고 있는 키 -> value +=1
            if(alpha.containsKey(ch)){
                alpha.put(ch,alpha.get(ch)+1);
            }else{  //없는 키 -> 맵함수에 저장
                alpha.put(ch, 1);
            }
            
        }

        //가장 높은 value 찾기
        int maxValue = Collections.max(alpha.values());
        char max = '?';
        int cnt=0;

        //전체돌면서 maxValue랑 같은 값을 가진 키 저장
        for(Map.Entry<Character, Integer>maxKey:alpha.entrySet()){
            if(maxKey.getValue()==maxValue){
                max = maxKey.getKey();
                cnt++;
            }
        }
        if(cnt>1){
            bw.write('?');
        }else{
            bw.write(max);
        }

        bw.flush();
        bw.close();


    }
}
