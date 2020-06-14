package medium;

/**
 * 扫雷游戏
 **/
public class Minesweeper {

    /**
     * 深度优先遍历
     * 时间复杂度O(N)
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0], col = click[1];
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            dfs(board, row, col);
        }

        return board;
    }

    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || row == board.length || col < 0 || col == board[0].length
            || board[row][col] != 'E') {
            return;
        }
        board[row][col] = 'B';
        // 判断当前周围的地雷情况
        int counter = detectM(board, row, col);
        if (counter > 0) {
            // 如果有地雷，则不继续进行遍历
            board[row][col] = (char) ('0' + counter);
        } else {
            // 如果没有地雷，则继续进行遍历
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    dfs(board, row + i, col + j);
                }
            }
        }
    }

    private int detectM(char[][] board, int row, int col) {
        int counter = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nextRow = row + i, nextCol = col + j;
                if (nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length
                    && board[nextRow][nextCol] == 'M') {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        new Minesweeper().updateBoard(new char[][] {{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'},
            {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}}, new int[] {3, 0});
    }
}
