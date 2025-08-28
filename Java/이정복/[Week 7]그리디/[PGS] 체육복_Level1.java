// 30분

import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 도난당한 학생
        Set<Integer> losts = new HashSet<>();
        // 체육복을 빌린 학생
        Set<Integer> borrow = new HashSet<>();
        // 여분이 있는 학생
        Set<Integer> reserves = new HashSet<>();

        for(int i : lost) {
            losts.add(i);
        }

        for(int i : reserve) {
            // lost와 reserve에 동시에 존재하는 학생은 체육복을 하나만 가지고 있다고 처리
            if(!losts.contains(i))
                reserves.add(i);
            else
                losts.remove(Integer.valueOf(i));
        }

        // while(true)

        // 양 옆 학생 중 한쪽에만 여분이 있는 학생 먼저 체육복을 빌려준다.

        // 한쪽에만 여분이 있는 학생이 더이상 없다면 양쪽에 있는 학생에게 체육복을 빌려준다.

        // 더 이상 옷을 빌려줄 수 없을 때까지 반복
        while(true) {
            boolean updated = false;
            
            // 한쪽에만 여분이 있는 학생
            for (int person : losts) {
                boolean prev = reserves.contains(person - 1);
                boolean next = reserves.contains(person + 1);
                if (!(prev&&next) && (prev)){
                    borrow.add(person);
                    reserves.remove(Integer.valueOf(person-1));
                    updated = true;
                }
                if (!(prev&&next) && (next)){
                    borrow.add(person);
                    reserves.remove(Integer.valueOf(person+1));
                    updated = true;
                }
            }

            // 양쪽에 여분이 있는 학생
            for (int person : losts) {
                boolean prev = reserves.contains(person - 1);
                boolean next = reserves.contains(person + 1);
                if (prev&&next){
                    borrow.add(person);
                    reserves.remove(Integer.valueOf(person-1));
                    updated = true;
                }
            }

            if(updated == false)
                break;
        }
        
        // 전체 학생 수 - 도난당한 학생 + 체육복을 빌린 학생
        return n - losts.size() + borrow.size();
    }
}