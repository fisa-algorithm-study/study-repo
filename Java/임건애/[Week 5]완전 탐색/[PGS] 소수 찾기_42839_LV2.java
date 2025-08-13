import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    
    public boolean isPrime(int n) {
        if (n < 2) return false;
        
        int r = (int)Math.sqrt(n);
        
        for (int i = 2; i <= r; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
    
    public void permutation(String parts, String str) {
        if (!parts.equals("")) {
            set.add(Integer.parseInt(parts));
        }
        
        for (int i = 0; i < str.length(); i++) {
            permutation(parts + str.charAt(i), str.substring(0, i) + str.substring(i + 1));
        }
    }
    
    public int solution(String numbers) {
        int count = 0;
        
        permutation("", numbers);
        
        for (Integer num : set) {
            if (isPrime(num)) {
                count++;
            }
        }
        
        return count;
    }
}