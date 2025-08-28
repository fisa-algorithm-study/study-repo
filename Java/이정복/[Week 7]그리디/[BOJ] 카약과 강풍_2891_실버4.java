package Kayak;
// 15분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        // line 32까지는 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        Set<Integer> lost = new HashSet<>();
        Set<Integer> reserve = new HashSet<>();
        Set<Integer> borrow = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<s; i++){
            lost.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<r; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(!lost.contains(temp))
                reserve.add(temp);
            else
                lost.remove(temp);
        }

        while(true) {
            boolean updated = false;

            for(int person : lost) {
                boolean prev = reserve.contains(person-1);
                boolean next = reserve.contains(person+1);

                if(!(prev && next) && prev) {
                    borrow.add(person);
                    reserve.remove(Integer.valueOf(person-1));
                    updated = true;
                }

                else if (!(prev && next) && next){
                    borrow.add(person);
                    reserve.remove(Integer.valueOf(person+1));
                    updated = true;
                }
            }

            for(int person : lost) {
                boolean prev = reserve.contains(person-1);
                boolean next = reserve.contains(person+1);

                if(prev && next) {
                    borrow.add(person);
                    reserve.remove(Integer.valueOf(person-1));
                    updated = true;
                }
            }

            if(updated == false)
                break;
        }

        System.out.println(lost.size() - borrow.size());
    }
}
