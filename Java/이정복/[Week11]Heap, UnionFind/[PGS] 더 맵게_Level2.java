package week11;

import java.util.PriorityQueue;

class Solution {
    // 최소힙 사용
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public int solution(int[] scoville, int K) {
        int answer = 0;

        for (int i : scoville) {
            minHeap.add(i);
        }

        // minHeap의 최소값이 K보다 작은 경우 계속 반복
        while(minHeap.peek() < K){
            try {
                mix(scoville);
            } catch (NullPointerException e) {
                /*
                    NullPointerException이 발생했다면
                        1. while문에서 k값을 넘지 않는 값이 있다는 것을 확인했고
                        2. Null이 반환되었다면 힙에 남은 항목이 1이었다는 것
                    -> 따라서 k보다 매운 음식을 만들 수 없는 상황. -1을 출력
                */
                return -1;
            }
            answer++;
        }

        return answer;
    }

    private int mix(int[] scoville) throws NullPointerException{
        Integer min = minHeap.poll();
        Integer min2 = minHeap.poll();

        // 여기서 result가 Null이라면 NullPointerException 발생 (큐가 비어있었다면)
        int result = min + min2*2;
        minHeap.add(result);

        return result;
    }
}