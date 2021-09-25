package KMP;

/**
 * 28. 实现 strStr()
 * @date 2021/9/24
 */
public class _28 {
    public static int strStr(String haystack, String needle) {
        if(needle==null){
            return 0;
        }
        if(needle == ""){
            return 0;
        }
        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        for (int i = 0; i < haystacks.length; i++) {
            for (int j = 0; j < needles.length; j++) {
                if(haystacks[i + j] == needles[j]){
                    if(j == needles.length - 1){
                        return i;
                    }
                }else {
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "";
        String needle = "";
        System.out.println(strStr(haystack, needle));
    }
}
