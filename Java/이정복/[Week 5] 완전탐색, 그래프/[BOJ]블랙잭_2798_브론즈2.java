import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        // 모든 카드에 대해 완전탐색
        int max = 0;
        int tempMax = 0;
        // 임시값을 첫 카드값으로
        for (int i=0; i<n; i++){
            tempMax = list.get(i);
            // 임시값에 두번째 카드값을 더한 후
            for(int j=0; j<n; j++){
                if(j != i){
                    tempMax += list.get(j);
                    // 임시값에 세번째 카드값을 시도해본 후 m을 넘지 않고
                    // 지금까지 탐색한 최대값보다 크다면 max 업데이트
                    for(int k = 0; k<n; k++){
                        if(k!=i && k!=j){
                            tempMax += list.get(k);
                            if(tempMax > max && tempMax <= m)
                                max = tempMax;
                            // 다음 카드를 탐색하기 전 임시값에서 지금 카드값을 빼기
                            tempMax -= list.get(k);
                        }
                    }
                    // 다음 카드를 탐색하기 전 임시값에서 지금 카드값을 빼기
                    tempMax -= list.get(j);
                }
            }
        }
        System.out.println(max);
    }
}
