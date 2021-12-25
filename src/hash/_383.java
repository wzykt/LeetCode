package hash;

/**
 * @date 2021-12-18 2021-12-18完成
 * @description 383. 赎金信
 *
 * 和_242类似,只不过桶的类型不同
 */
public class _383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        int[] bucket = new int[26];

        for (int i = 0; i < ransomNote.length(); i++) {
            bucket[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            bucket[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < bucket.length; i++) {
            if(bucket[i] > 0){
                return false;
            }
        }
        return true;
    }
}
