import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static HashMap<Character,ArrayList<Character>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =  Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            char middle = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            map.putIfAbsent(middle, new ArrayList<>());

            map.putIfAbsent(left, new ArrayList<>());
            map.get(middle).add(left);

            map.putIfAbsent(right, new ArrayList<>());
            map.get(middle).add(right);
        }

        preorder('A');
        sb.append("\n");
        inorder('A');
        sb.append("\n");
        postorder('A');

        System.out.println(sb);
        br.close();
    }

    private static void preorder(Character c) {
        sb.append(c);
        Character left = map.get(c).get(0);
        if(left != '.') preorder(left);
        Character right = map.get(c).get(1);
        if(right != '.') preorder(right);
    }

    private static void inorder(Character c) {
        Character left = map.get(c).get(0);
        if(left != '.') inorder(left);
        sb.append(c);
        Character right = map.get(c).get(1);
        if(right != '.') inorder(right);
    }

    private static void postorder(Character c) {
        Character left = map.get(c).get(0);
        if(left != '.') postorder(left);
        Character right = map.get(c).get(1);
        if(right != '.') postorder(right);
        sb.append(c);
    }
}