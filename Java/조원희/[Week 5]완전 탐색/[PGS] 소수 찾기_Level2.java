import java.util.*;
import java.io.*;

class Solution {
    private static HashSet<Integer> map = new HashSet<>();
    private static int[] arr;
    private static boolean[] visited;

    public int solution(String numbers) {
        int answer = 0;

        int length = numbers.length();
        arr = new int[length];
        for(int i = 0; i < length; i++){
            arr[i] = numbers.charAt(i) - '0';
        }

        visited = new boolean[length];

        for(int i = 0; i < length; i++){
            solution(i, arr[i]+"");
        }


        return map.size();
    }

    private static void solution(int index, String now){
        visited[index] = true;
        if(isPrim(Integer.parseInt(now)))  map.add(Integer.parseInt(now));

        for(int i = 0; i < visited.length; i++) {
            if(visited[i])    continue;

            String next = now + arr[i];

            solution(i, next);
        }

        visited[index] = false;
    }

    private static boolean isPrim(int number){
        if(number < 2) return false;
        for(int i = 2; i < number; i++){
            if(number % i == 0){
                return false;
            }
        }

        return true;
    }
}