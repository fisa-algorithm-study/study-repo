import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Main {
    public static void main(String args[]) throws Exception {
        /*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] input = reader.readLine().split(" "); */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int num = Integer.parseInt(s);
        int minConstructor = num - 9 * s.length();

        for (int i = minConstructor; i< num; i++) {
            String numString= Integer.toString(i);
            int sum = 0;
            for (char c : numString.toCharArray()) {
                sum += (c - '0');
            }

            if (sum + i == num) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}