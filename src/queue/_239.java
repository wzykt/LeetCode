package queue;

import java.util.*;

/**
 * @date 2021-12-22 2021-12-24参考答案完成
 * @description 239. 滑动窗口最大值
 *
 *
 */
public class _239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
            // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            while(!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }
            // 2.既然是单调，就要保证每次放进去的数字要比末尾的都大，否则也弹出
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
            if(i >= k - 1){
                res[idx++] = nums[deque.peek()];
            }
        }
        return res;
    }
    //暴力，超时
    /*public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>(k);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (deque.size() == k) {
                res.add(max(deque));
                deque.removeFirst();
                deque.add(nums[i]);
            } else {
                deque.add(nums[i]);
            }
        }
        res.add(max(deque));
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public int max(Deque<Integer> deque) {
        int max = Integer.MIN_VALUE;
        for (Integer i : deque) {
            max = Math.max(i, max);
        }
        return max;
    }*/

    public static void main(String[] args) {
        _239 obj = new _239();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(obj.maxSlidingWindow(nums, 3)));
    }
}
