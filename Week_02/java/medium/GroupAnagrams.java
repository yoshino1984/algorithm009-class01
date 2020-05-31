package medium;

import java.util.*;

/**
 * 字符异位词分组
 **/
public class GroupAnagrams {

    /**
     * 对每个str 针对char进行排序，转换成key，
     * 然后针对key进行统计返回
     * 时间复杂度O(NKlogK) k为strs中字符串的最大长度
     * 时间复杂度O(NK)
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> stringListMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            stringListMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(stringListMap.values());
    }

    /**
     * 对每个str 通过计数转化成组合key，然后进行统计
     * 相较于排序统计方法，能够节约点空间
     * 时间复杂度 O(NK) k为strs中字符串的最大长度
     * 空间复杂度 O(NK)
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> stringListMap = new HashMap<>();
        // 针对小写字母优化
        int[] count = new int[26];

        for (String str : strs) {
            Arrays.fill(count, 0);
            str.chars().forEach(i -> count[i - 'a']++);

            StringBuilder keySbr = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                keySbr.append(count[i]).append("#");
            }
            stringListMap.computeIfAbsent(keySbr.toString(), k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(stringListMap.values());
    }


}
