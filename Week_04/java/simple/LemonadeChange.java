package simple;

/**
 * 柠檬水找零
 **/
public class LemonadeChange {

    /**
     * 贪心算法 遍历可能性 主要是对于20美元支付的情况，10美元+5美元的支付情况优先级 》 3张5美元的情况
     * 时间复杂度O(N)）
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five <= 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
