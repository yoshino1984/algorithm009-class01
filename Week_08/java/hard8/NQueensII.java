package hard8;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * N 皇后ii
 **/
public class NQueensII {

    public int totalNQueens(int n) {
        AtomicInteger ans = new AtomicInteger();
        n = (1 << n) - 1;
        dfs(ans, n, 0, 0, 0);
        return ans.get();
    }

    private void dfs(AtomicInteger ans, int n, int col, int pie, int na) {
        if (col == n) {
            ans.incrementAndGet();
            return;
        }

        int pos = (n & ~(col | pie | na));
        while (pos != 0) {
            int p = pos & (-pos);
            dfs(ans, n, col | p, (pie | p) << 1, (na | p) >> 1);
            pos = pos & (pos - 1);
        }
    }

}
