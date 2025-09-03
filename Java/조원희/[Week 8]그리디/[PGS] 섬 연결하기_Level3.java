import java.util.*;
import java.io.*;

class Solution {
    static class Node {
        int next;
        int score;

        public Node(int next, int score) {
            this.next = next;
            this.score = score;
        }
    }

    private static HashMap<Integer, ArrayList<Node>> map = new HashMap<>();

    public int solution(int n, int[][] costs) {
        int answer = 0;

        for(int i = 0; i < costs.length; i++){
            map.putIfAbsent(costs[i][0], new ArrayList<>());
            map.putIfAbsent(costs[i][1], new ArrayList<>());

            map.get(costs[i][0]).add(new Node(costs[i][1], costs[i][2]));
            map.get(costs[i][1]).add(new Node(costs[i][0], costs[i][2]));
        }

        answer = BFS(n, 0);

        return answer;
    }

    public int BFS(int n, int num){
        int answer = 0;
        int island = n;

        boolean[] visit = new boolean[n];

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.score));

        visit[num] = true;
        for(Node node: map.get(num)){
            pq.add(node);
        }

        while(!pq.isEmpty() && island != 0){
            Node node = pq.poll();

            if(!visit[node.next]){
                System.out.println(node.next);
                answer += node.score;
                visit[node.next] = true;
                island--;

                for(Node nextIsland: map.get(node.next)){
                    pq.add(nextIsland);
                }
            }
        }

        return answer;
    }
}