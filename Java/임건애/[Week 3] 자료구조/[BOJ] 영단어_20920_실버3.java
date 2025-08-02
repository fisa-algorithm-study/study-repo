import java.util.*;
import java.io.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> words = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {   // 길이가 M 이상인 단어만
                words.put(word, words.getOrDefault(word, 0) + 1);
            }
        }

        List<String> list = new ArrayList<>(words.keySet());    // 단어들 넣은 배열 생성

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int valueA = words.get(a);
                int valueB = words.get(b);

                if (valueA != valueB) {   // 빈도수 저장해둔거
                    return valueB - valueA;
                }
                else if (a.length() != b.length()) {    // 단어의 길이가 길수록 앞으로
                    return b.length() - a.length();
                }
                else {      // 문자열 사전순 비교 a.compareTo(b)일때 a가 앞이면 음수
                    return a.compareTo(b);
                }
            }
        });

        // for (String word : list) {
        //     System.out.println(word);
        // }

        //시간초과때메 StringBuilder 쓰겠습니다...
        StringBuilder sb = new StringBuilder();

        for (String word : list) {
            sb.append(word).append("\n");
        }

        System.out.print(sb);

    }
}