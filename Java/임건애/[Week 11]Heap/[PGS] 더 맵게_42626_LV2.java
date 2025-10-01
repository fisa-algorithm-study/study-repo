import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        // 힙으로 변환
        for (int n : scoville) {
            heap.add(n);
        }
        
        while (heap.peek() < K && heap.size() > 1) {
            int s1 = heap.poll();
            int s2 = heap.poll();
            
            if (s1 >= K) break;
            
            int newFood = s1 + (s2 * 2);
            heap.add(newFood);
            
            answer++;
        }
        
        return (heap.peek() < K) ? -1 : answer;
    }
}