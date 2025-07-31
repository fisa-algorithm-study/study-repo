import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> map = new HashMap<>();
        HashMap<String, Integer> map_rev = new HashMap<>();
        for(int i = 1; i <= N; i++){
            String pokemon = br.readLine();
            map.put(i, pokemon);
            map_rev.put(pokemon, i);
        }

        for(int i = 1; i <= M; i++){
            String pokemon = br.readLine();

            if(pokemon.charAt(0) >= '1' && pokemon.charAt(0) <= '9'){
                int key = Integer.parseInt(pokemon);
                sb.append(map.get(key)).append("\n");
            } else {
                sb.append(map_rev.get(pokemon)).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}