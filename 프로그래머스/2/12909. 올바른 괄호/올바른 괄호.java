class Solution {
    boolean solution(String s) {
        return s.chars().reduce(0, (cnt, c) -> c == '(' ? cnt + 1 : cnt > 0 ? cnt - 1 : -s.length()) == 0;
    }
}