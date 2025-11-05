class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] result = new int[2];

        int left = 0, right = 0, sum = 0, len = sequence.length;

        for(right = 0; right < sequence.length; right++) {
            sum += sequence[right];

            while(right < sequence.length && sum > k) {
                sum -= sequence[left];
                left++;
            }

            if(sum == k) {
                if(len > right - left) {
                    len = right - left;
                    result[0] = left;
                    result[1] = right;
                }
            }
        }

        return result;
    }
}