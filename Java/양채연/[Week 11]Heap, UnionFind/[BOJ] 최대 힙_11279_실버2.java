import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
//        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int n = Integer.parseInt(br.readLine());
        for(int i =0;i<n;i ++){
            int num = Integer.parseInt(br.readLine());
            if(num ==0){
                if(pQ.isEmpty())
                    sb.append(0).append("\n");
                else{
                    sb.append(pQ.poll()).append("\n");
                }
            }else{
                pQ.offer(num);
            }
        }
        System.out.println(sb);
    }
}