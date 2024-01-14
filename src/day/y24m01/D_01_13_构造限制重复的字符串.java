package day.y24m01;

/**
 * @Author CuiChengLong
 * @Date 2024/1/13 20:58
 * @Description
 */

public class D_01_13_构造限制重复的字符串 {

    public static String repeatLimitedString(String s, int repeatLimit) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++cnt[s.charAt(i) - 'a'];
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 25, j = 24; i >= 0; --i) {
            j = Math.min(j, i - 1);
            while (true) {
                for (int k = Math.min(cnt[i], repeatLimit); k > 0; --k) {
                    ans.append((char) ('a' + i));
                    --cnt[i];
                }
                if (cnt[i] == 0) {
                    break;
                }
                while (j >= 0 && cnt[j] == 0) {
                    --j;
                }
                if (j < 0) {
                    break;
                }
                ans.append((char) ('a' + j));
                --cnt[j];
            }
        }
        return ans.toString();
    }



    public static void main(String[] args) {
        System.out.println(repeatLimitedString("aababab", 2));
    }

}
