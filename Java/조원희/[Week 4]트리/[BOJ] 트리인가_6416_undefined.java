import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int num = 1;
        while (true) {
            Map<Integer, Integer> map = new HashMap<>();
            Set<Integer> set = new HashSet<>();
            boolean isTree = true;

            int edge = 0;
            while (true) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();

                if (u == -1 && v == -1) {
                    System.out.println(sb);
                    return;
                }
                if (u == 0 && v == 0) break;

                edge++;

                if (map.containsKey(v)) isTree = false;
                else map.put(v, 1);

                set.add(u);
                set.add(v);
            }

            if (set.size() == 0) {
                isTree = true;
            } else  {
                if (isTree) {
                    int root = 0;
                    for (int node : set) {
                        if (!map.containsKey(node)) root++;
                    }
                    if (root != 1) isTree = false;

                    if (edge != set.size() - 1) isTree = false;
                }
            }

            sb.append("Case ").append(num++).append(" is ");
            if (isTree) sb.append("a tree.").append("\n");
            else sb.append("not a tree.").append("\n");

        }
    }
}