package medium9;

public class StringToIntegerAtoi {

    /**
     * O(N)
     */
    public static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int total = 0;
        int index = 0;
        int len = str.length();

        // 处理空白字符
        while (index < len && chars[index] == ' ') {
            index++;
        }
        if (index == len) {
            return 0;
        }

        boolean negative = false;
        if (chars[index] == '-') {
            negative = true;
            index++;
        } else if (chars[index] == '+') {
            index++;
        } else if (!Character.isDigit(chars[index])) {
            return 0;
        }


        while (index < len && Character.isDigit(chars[index])) {
            int digit = Character.getNumericValue(chars[index]);
            if (total > (Integer.MAX_VALUE - digit) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            total = total * 10 + digit;
            index++;
        }

        return negative ? -total : total;
    }



    public static void main(String[] args) {
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("-2147483649"));
        System.out.println(myAtoi("-2147483647"));
        System.out.println(myAtoi("2147483646"));
        System.out.println(myAtoi("2147483648"));
        System.out.println(myAtoi("+2147483648"));
        System.out.println(myAtoi("+-2147483648"));
        System.out.println(myAtoi("+-+-2147483648"));
        System.out.println(myAtoi("++-2147483648"));
        System.out.println(myAtoi("-+-2147483648"));
        System.out.println(myAtoi("  0000000000012345678"));
        System.out.println(myAtoi("2147483800"));
    }
}
