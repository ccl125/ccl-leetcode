package hot100;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/19 9:56
 * @Description
 */
public class H_最小覆盖子串 {

    public String minWindow(String s, String t) {
        String res = "";
        int sLength = s.length();
        int tLength = t.length();
        if (s == null || t == null || sLength == 0 || tLength == 0 || sLength < tLength) {
            return res;
        }
        int targetCount = tLength;
        int[] needs = new int[128];
        int[] windows = new int[128];
        char[] charArray = t.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            needs[charArray[i]]++;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int minLength = sLength + 1;
        while (right < sLength) {
            char c = s.charAt(right);
            windows[c]++;
            if (needs[c] > 0 && needs[c] >= windows[c]) {
                count++;
            }

            while (count == targetCount) {
                char c1 = s.charAt(left);
                if (needs[c1] > 0 && needs[c1] >= windows[c1]) {
                    count--;
                }
                if (minLength > right - left + 1) {
                    minLength = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                windows[c1]--;
                left++;
            }
            right++;
        }
        return res;
    }

}
