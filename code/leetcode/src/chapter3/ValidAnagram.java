package chapter3;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {

    }

    public static boolean isAnagram2(String s, String t) {
        //排序 字符数组
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public static boolean isAnagram1(String s, String t) {
        //哈希
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            freq[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); ++i) {
            if (--freq[t.charAt(i)] < 0) {
                return false;
            }
        }
        return s.length() == t.length();
    }

    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            counter[s.charAt(i) - 'a']++;
            counter[s.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
