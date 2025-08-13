import java.util.HashSet;
import java.util.Set;

class Solution {
    public static Set<Integer> primes = new HashSet<>();

    public int solution(String numbers) {
        primes.clear();
        int[] arr = new int[numbers.length()];

        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = numbers.charAt(i) - '0';
        }

        boolean[] visited = new boolean[numbers.length()];

        for (int r = 1; r <= numbers.length(); r++) {
            permutation(0, numbers.length(), r, arr, visited, new StringBuilder());
        }

        System.out.println(primes);
        return primes.size();
    }

    public void permutation(int depth, int n, int r, int[] arr, boolean[] visited, StringBuilder sb) {
        if (depth == r) { 
            int result = Integer.parseInt(sb.toString());
            if (isPrime(result)) {
                primes.add(result);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(arr[i]); 
                permutation(depth + 1, n, r, arr, visited, sb);
                sb.deleteCharAt(sb.length() - 1); 
                visited[i] = false;
            }
        }
    }

    public boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
