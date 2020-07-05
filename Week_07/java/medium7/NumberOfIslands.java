package medium7;

/**
 * 岛屿数量
 **/
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        UnionFind unionFind = new UnionFind(grid);
        int rl = grid.length;
        int cl = grid[0].length;

        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i > 0 && grid[i - 1][j] == '1') {
                        unionFind.union(i * cl + j, i * cl + j - cl);
                    }
                    if (i < rl - 1 && grid[i + 1][j] == '1') {
                        unionFind.union(i * cl + j, i * cl + j + cl);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        unionFind.union(i * cl + j, i * cl + j - 1);
                    }
                    if (j < cl - 1 && grid[i][j + 1] == '1') {
                        unionFind.union(i * cl + j, i * cl + j + 1);
                    }
                }
            }
        }


        return unionFind.getCount();
    }

    class UnionFind {
        private int[] parent;

        private int count;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public UnionFind(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            this.parent = new int[row * col];
            this.count = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * col + j] = i * col + j;
                        count++;
                    } else {
                        parent[i * col + j] = -1;
                    }
                }
            }
        }

        public int find(int val) {
            while (val != parent[val]) {
                parent[val] = parent[parent[val]];
                val = parent[val];
            }

            return val;
        }

        public void union(int v1, int v2) {
            int root1 = find(v1);
            int root2 = find(v2);
            if (root1 != root2) {
                count--;
                parent[root1] = root2;
            }
        }

        public int getCount() {
            return count;
        }
    }
}
