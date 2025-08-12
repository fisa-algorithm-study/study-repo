import java.util.*;

class Solution {
    private static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    private static HashSet<Integer> set;

    public int solution(int n, int[][] wires) {

        for(int i = 0; i < n - 1; i++){
            int node = wires[i][0];
            int v = wires[i][1];

            map.putIfAbsent(node, new ArrayList<>());
            map.putIfAbsent(v, new ArrayList<>());

            map.get(node).add(v);
            map.get(v).add(node);
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < n - 1; i++){
            int start = wires[i][0];
            int end = wires[i][1];

            set = new HashSet<>();
            solution(start, start, end);
            int first = set.size();

            set = new HashSet<>();
            solution(end, start, end);
            int last = set.size();

            answer = Math.min(Math.abs(first - last), answer);
        }

        return answer;
    }

    private static void solution(int node, int start, int end){
        set.add(node);

        for(int value: map.get(node)){
            if(set.contains(value) || value == end || value == start)   continue;
            solution(value, start, end);
        }
    }
}