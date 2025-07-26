import java.util.*;

public class Solution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Map<Character, Integer> letters = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toUpperCase(str.charAt(i));
            if (letters.containsKey(ch)) {
                letters.put(ch, letters.get(ch) + 1);
            }
            else {
                letters.put(ch, 1);
            }
        }

        int maxValue = Collections.max(letters.values());
        char maxKey = ' ';
        int count = 0;

        for (Map.Entry<Character, Integer> entry : letters.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();

            if (maxValue == value) {
                maxKey = key;
                count++;
            }
        }

        System.out.println(count == 1 ? maxKey : '?');
    }
}
