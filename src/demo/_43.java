package demo;

/**
 * 43. 字符串相乘
 *
 * @date 2021/9/27
 */
public class _43 {
    public static String multiply(String num1, String num2) {
        char[] s1 = num1.toCharArray();
        char[] s2 = num2.toCharArray();

        int len1 = s1.length;
        int len2 = s2.length;

        long number1 = 0;
        long number2 = 0;
        for (int i = 0; i < len1; i++) {
            number1 += (s1[i] - 48) * Math.pow(10, len1 - i - 1);
        }
        for (int i = 0; i < len2; i++) {
            number2 += (s2[i] - 48) * Math.pow(10, len2 - i - 1);
        }
        System.out.println(number1);
        System.out.println(number2);
        return number1 * number2 + "";
    }

    public static void main(String[] args) {
//        System.out.println('0' + 0);
        String s = multiply("123", "456");
        System.out.println(s);
    }
}
