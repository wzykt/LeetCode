package demo;

/**
 * 275. H 指数 II
 *
 * @date 2021/9/23
 * @description 主要是弄明白h指数是什么意思
 * 只要理解题目中 “ h 篇论文分别被引用了至少 h 次” 这句话就行了。没看见“分别”这个词
 */
public class _275 {
    public int hIndex(int[] citations) {
        int left = -1, right = citations.length;
        int res = 0;
        while (left + 1 != right) {
            int m = (left + right) / 2;
            if (citations.length - m >= citations[m]) {
                right = m;
                res = Math.max(res, citations[m]);
            } else {
                left = m;
            }
        }
        return res;
    }
}
