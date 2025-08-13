import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Main {
    public static int max = 0;
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] input = reader.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int sum = 0;
        /* 두번 째 줄 입력 받아서 리스트로 처리하기 */
        int[] arr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean[] visited = new boolean[arr.length];
        combination(arr, visited, 0, a, 3, b);
        System.out.println(max);
    }

    public static void combination(int[] arr, boolean[] visited, int start, int n, int r, int target) {
        if(r == 0) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    sum += arr[i];
                }
            }
            if ((sum <= target) && (sum > max)) {
                max = sum;
            }
            return;
        } else {
            for(int i = start; i < n; i++) {
                visited[i] = true;
                combination(arr, visited, i + 1, n, r - 1, target);
                visited[i] = false;
            }
        }
    }
}