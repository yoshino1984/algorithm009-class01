学习笔记
动态规划
注意点主要是状态的定义和状态转移方程的推导

不同路径2 的状态转移方程：dp[i][j] = (grid[i][j] == 1 ? 0 : dp[i][j + 1] + dp[i][j - 1])

字符串算法