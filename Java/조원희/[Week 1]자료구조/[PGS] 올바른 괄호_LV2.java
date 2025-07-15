import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();

        // String 길이 만큼
        for(int i = 0; i < s.length(); i++){
            // String에 index 위치의 값 가져오기
            char sIn = s.charAt(i);

            // 만약 그 값이 ( 이면 스택에 넣기
            if(sIn == '(')    st.push(sIn);
            else {  // 아니면 검증 시작
                if(st.empty())  return false;  // 스택이 비어 있을 경우

                char sOut = st.pop();
                if(sOut != '(')    return false; // ()가 올바르지 않을 경우
            }
        }

        if(st.empty())  return true; // 만약 스택에 값이 안남아 있을 경우
        else    return false;
    }
}