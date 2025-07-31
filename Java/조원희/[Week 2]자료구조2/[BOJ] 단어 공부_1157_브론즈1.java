import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(c >= 'a') {
                c -= 'a' - 'A';
            }

//            if(map.containsKey(c)) {
//                map.put(c, map.get(c) + 1);
//            } else {
//                map.put(c, 1);
//            }
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int max = 0;
        char answer = '?';

        for(char key: map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
                answer = key;
            } else if(map.get(key) == max)  answer = '?';
        }

        System.out.println(answer);
    }
}
