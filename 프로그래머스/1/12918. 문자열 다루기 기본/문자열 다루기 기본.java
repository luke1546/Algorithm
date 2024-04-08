import java.util.regex.*;
class Solution {
    public boolean solution(String s) {
        Pattern p = Pattern.compile("\\D");
        Matcher m = p.matcher(s);
        return (!m.find() && (s.length() == 4 || s.length() == 6));
    }
}