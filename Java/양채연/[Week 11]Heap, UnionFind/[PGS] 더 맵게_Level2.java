import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        for(int i = 0 ;i < scoville.length;i++){
            pQ.add(scoville[i]);
        }
        while(pQ.peek()<K){
            if(pQ.size()>=2){
                int first = pQ.poll();
                int second = pQ.poll();
                pQ.add(first+second*2);
                answer++;
            }else{
                return -1;
            }
        }

        return answer;
    }
}