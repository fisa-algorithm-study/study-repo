import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // Scanner보다 실행 시간이 빠른 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer Text = new StringTokenizer(br.readLine(), " ");

        // Text의 요소들을 arr 정수형 배열로 파싱
        Balloons Balloons = new Balloons(size);
        for (int index=0; index<size; index++) {
            int value = Integer.parseInt(Text.nextToken());
            Balloons.InitBalloon(index, value);
        }

        // Balloons.printBallons();

        int index = 0;
        for (int i = 0; i < size; i++){
            Balloons.pop(index);
            int BalloonNumber = Balloons.getBalloonNumber(index);
            if(BalloonNumber < 0){
                for (int j=0; j<Math.abs(BalloonNumber); j++) {
                    index = Balloons.prev(index, size);
                }
            }
            else{
                for (int j=0; j<BalloonNumber; j++) {
                    index = Balloons.next(index, size);
                }
            }
        }
    }
}

class Balloon{
    private int number;
    private boolean isPop;

    public Balloon(int value){
        number = value;
        isPop = false;
    }

    public void setNumber(int value){
        number = value;
    }

    public int getNumber(){
        return number;
    }
    public boolean isBalloonPop(){
        return isPop;
    }

    public boolean Pop() throws Exception {
        if (isPop == false){
            isPop = true;
            return true;    // 터뜨리기 성공 시 true 리턴
        }
        else throw new Exception("이미 터진 풍선입니다.");  // 터뜨리기 실패 시 예외 발생
    }
}

class Balloons{
    private Balloon[] ballonList;
    private int size;

    public Balloons(int value){
        size = value;
        ballonList = new Balloon[size];
    }

    public void InitBalloon(int index, int value){
        ballonList[index] = new Balloon(value);
    }

    public int getBalloonNumber(int index){
        return ballonList[index].getNumber();
    }

    public boolean getBalloonPoped(int index){
        return ballonList[index].isBalloonPop();
    }

    public void printBallons(){
        System.out.println("---------------------------");
        for (int index=0; index < size; index++){
            System.out.printf("풍선 번호-(%d) \t 상태-%B\n", ballonList[index].getNumber(), ballonList[index].isBalloonPop());
        }
        System.out.println("---------------------------");
    }

    public int next(int index, int size){
        int temp = index;
        if (!isEverythingPoped()){
            while(true){
                temp = searchNext(temp, size);
                if(!getBalloonPoped(temp))
                    return temp;
            }
        }
        return temp;
    }

    public int prev(int index, int size){
        int temp = index;
        if (!isEverythingPoped()) {
            while (true) {
                temp = searchPrev(temp, size);
                if (!getBalloonPoped(temp))
                    return temp;
            }
        }
        return temp;
    }

    public int searchNext(int index, int size){
        if(index == size-1){
            return 0;
        }
        else return index+1;
    }

    public int searchPrev(int index, int size){
        if(index == 0){
            return size-1;
        }
        else return index-1;
    }

    public void pop(int index) {
        System.out.printf("%d ", index+1);
        try {
            ballonList[index].Pop();
        } catch (Exception E) {
            System.out.printf("\n에러 발생. 이미 터진 풍선입니다.: %s", E);
        };
    }

    public boolean isEverythingPoped(){
        for(int i=0; i<size; i++){
            if(ballonList[i].isBalloonPop() == false)
                return false;
        }
        return true;
    }
}