import java.util.*;
import java.io.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> pokemon = new HashMap<>();
        Map<String, Integer> reverse = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            pokemon.put(i, name);
            reverse.put(name, i);
        }

        // 잘 되나 확인용
        // for (int key : pokemon.keySet()) {
        //    System.out.println(key + " : " + pokemon.get(key));
        // }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (input.matches("\\d+")) {    // 문자열 전체가 숫자일 때만 true (정규식 어려워요..잘 아시는 분?)
                int num = Integer.parseInt(input);
                System.out.println(pokemon.get(num));
            } else {    // 포켓몬 이름일 때
                System.out.println(reverse.get(input));
            }
        }
    }
}