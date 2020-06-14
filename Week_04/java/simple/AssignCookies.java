package simple;

import java.util.Arrays;

/**
 * 分发饼干
 **/
public class AssignCookies {

    /**
     * 贪心解法（因为限制每个小朋友最多只有一块饼干）
     * 双指针
     * 时间复杂度O(NlogN) 排序消耗，N为g和s数量的较大值
     */
    public int findContentChildren(int[] g, int[] s) {
        int cnt = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int sIndex = 0;
        for (int i = 0; i < g.length; i++) {
            while (sIndex < s.length) {
                if (g[i] <= s[sIndex++]) {
                    cnt++;
                    break;
                }
            }
            if (sIndex == s.length) {
                break;
            }
        }
        return cnt;
    }

}
