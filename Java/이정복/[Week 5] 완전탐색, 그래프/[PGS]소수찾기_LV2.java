import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    // 전역적으로 사용할 소수 set
    private Set<Integer> resultSet = new HashSet<>();

    // 자릿수 숫자들을 ArrayList<Integer> 형식으로 파싱 후 dfs
    public int solution(String numbers) {
        ArrayList<Integer> list = getDigits(numbers);

        dfs(list, 0);

        return resultSet.size();
    }

    // dfs : 자릿수를 늘려가면서 탐색, 리스트를 깊은 복사 하며, 리스트가 빈다면 return
    public void dfs(ArrayList<Integer> list, int prevValue) {
        // 입력받은 리스트가 비어있다면 return
        if(list.isEmpty())
            return;

        // 받은 입력값에 10을 곱해 ArrayList 순회를 준비
        int tempValue = prevValue * 10;

        // 입력을 받아 중복되지 않는 숫자를 방문
        for(int i=0; i<list.size(); i++){
            // 방문한 숫자를 더하고
            int curNum = list.get(i);
            tempValue += curNum;

            if(isPrime(tempValue)){                     // 만약 tempValue가 소수이고
                if(!resultSet.contains(tempValue)){     // 이미 나온 결과값이 아니라면
                    resultSet.add(tempValue);           // 결과값 set에 추가
                }
            }

            // 깊이우선탐색, 방문한 숫자를 더한 값으로 더 깊이 탐색
            ArrayList<Integer> tempList = new ArrayList<>(list);
            tempList.remove(i);

            // 방문이 끝났다면 방문한 숫자를 빼고 계속 리스트 탐색
            dfs(tempList, tempValue);

            tempValue -= curNum;
        }
    }

    // 숫자가 소수인지 판단하는 함수
    public boolean isPrime(int number) {
        // 0, 1, 2 예외처리
        if(number < 2)
            return false;
        if(number == 2)
            return true;

        // 소수 판별
        for(int i=2; i<=Math.sqrt(number); i++){
            if (number % i == 0)
                return false;
        }
        return true;
    }

    // 자릿수 구하는 함수
    public ArrayList<Integer> getDigits(String numbers) {
        ArrayList<Integer> list = new ArrayList();

        for(int i=0; i<numbers.length(); i++){
            list.add(Integer.parseInt(Character.toString(numbers.charAt(i))));
        }

        return list;
    }
}
