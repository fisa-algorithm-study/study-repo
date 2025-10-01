import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i: scoville)    pq.add(i);

        int answer = 0;
        while(pq.peek() < K) {
            int mix = pq.poll();
            if(pq.size() == 0 || pq.peek() == 0){
                return -1;
            }
            mix += pq.poll() * 2;
            pq.add(mix);
            answer++;
        }

        return answer;
    }
}