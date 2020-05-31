package simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 有效的字母异位词
 **/
public class ValidAnagram {

    /**
     * 排序解法
     * 时间复杂度O(NlogN)
     */
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    /**
     * 使用数组简单hash计数的方式
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        return Arrays.stream(counter).allMatch(count -> count == 0);
    }

    /**
     * 兼容unicode字符的方法
     */
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, AtomicInteger> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countMap.computeIfAbsent(s.charAt(i), k -> new AtomicInteger()).incrementAndGet();
            countMap.computeIfAbsent(t.charAt(i), k -> new AtomicInteger()).decrementAndGet();
        }

        return countMap.values().stream().allMatch(count -> count.get() == 0);
    }



}
