import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> Heap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                if(Heap.isEmpty()){
                    sb.append(0).append("\n");
                } else {
                    sb.append(Heap.poll()).append("\n");
                }
            } else {
                Heap.add(num);
            }
        }
        System.out.println(sb);
    }
}