import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
     public static void main(String[] args) throws Exception {
         TreeMap<Character, Integer> map = new TreeMap<>();

         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String Text = br.readLine().toUpperCase();

         for(int i = 0; i < Text.length(); i++) {
             char now = Text.charAt(i);

             if(map.get(now) != null){
                 map.replace(now, map.get(now)+1);
             }
             else {
                 map.put(now, 1);
             }
         }

         int max = 0;
         char result = '?';

         for (Map.Entry<Character, Integer> entry : map.entrySet()) {
             int now = entry.getValue();
             if (now > max) {
                 max = now;
                 result = entry.getKey();
             }
             else if (now == max) {
                 result = '?';
             }
         }
         System.out.println(result);
     }
}