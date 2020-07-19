package simple9;


import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符
 **/
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        Map<Character, Integer> charCntMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            int cnt = charCntMap.getOrDefault(key, 0);
            charCntMap.put(key, cnt + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (charCntMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
