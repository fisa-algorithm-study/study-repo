import java.io.*;
import java.util.*;

class Node {
    int many;
    String word;

    public Node(int many, String word) {
        this.many = many;
        this.word = word;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 1; i <= N; i++){
            String word =  br.readLine();
            if(word.length() >= M)
                map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List <Node> list = new ArrayList<>();
        for(String word : map.keySet()){
            list.add(new Node(map.get(word), word));
        }

        list.sort((o1, o2) -> {
            if(o1.many != o2.many){
                return o2.many - o1.many;

            }
            if(o1.word.length() != o2.word.length()){
                return o2.word.length() - o1.word.length();
            }
            return o1.word.compareTo(o2.word);
        });


        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i).word).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}