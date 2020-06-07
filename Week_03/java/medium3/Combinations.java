package medium3;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 *
 * @author wangxin
 * 2020/6/7 23:04
 * @since
 **/
public class Combinations {

    /**
     * 回溯法
     */
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        this.k = k;
        this.n = n;
        this.myCombine(1, new ArrayList<>());
        return ans;
    }

    List<List<Integer>> ans;
    int n;
    int k;
    private void myCombine(int cur, List<Integer> list) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // 第 list.size()-1 个元素的添加
        for (int i = cur; i <= n; i++) {
            list.add(i);
            myCombine(i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Combinations().combine(4, 2);
    }

}
