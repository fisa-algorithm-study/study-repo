import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        // Scanner보다 실행 시간이 빠른 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Text = br.readLine();

        LinkedList<Character> list = new LinkedList();
        int length = Text.length();
        for (int index=0; index<Text.length(); index++){
            list.add(Text.charAt(index));
        }

        while(!list.isEmpty()){
            for (int index=0; index<Text.length(); index++){
                if(index != length - 1){
                    if(list.get(index) == '(' && list.get(index+1) == ')'){
                        list.remove(index);
                        list.remove(index);
                        length -= 2;
                        break;
                    }
                }
                else{
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
        return;
    }
}