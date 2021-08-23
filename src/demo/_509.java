package demo;

/**
 * 509斐波那契数
 *
 * @date 2021/8/23
 * @description 动态规划去做，不使用暴力递归
 */
public class _509 {
    public static int fib(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        int[] arr = new int[n + 1];
        arr[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
        //暴力递归
//        if(n == 1){
//            return 1;
//        }
//        if(n == 0){
//            return 0;
//        }
//        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fib(4));
    }
}
