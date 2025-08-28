class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] arr = new int[n+1];

        for(int i = 1 ; i <=reserve.length-1;i ++){
            arr[reserve[i]]++;
        }
        for(int i = 1; i <=lost.length-1;i++){
            arr[lost[i]]--;
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] == -1) {
                if (i > 1 && arr[i - 1] == 1) {
                    arr[i - 1]--;
                    arr[i]++;
                } else if (i<n && arr[i + 1] == 1) {
                    arr[i + 1]--;
                    arr[i]++;
                }
            }
        }

        for(int i = 1; i <= n;i ++){
            if(arr[i]==-1)
                answer--;
        }
        return answer;
    }
}