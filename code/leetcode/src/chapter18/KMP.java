package chapter18;

class KMP {
    public static void main(String[] args) {
        String pattern = "ABABCABAA";
        String text = "ABABABCABAABABABAB";
        KMP kmp = new KMP();
        kmp.kmpSearch(text, pattern);
    }

    public void kmpSearch(String text, String pattern) {
        int n = pattern.length();
        int m = text.length();
        int[] prefix = new int[n];
        prefixTable(pattern, prefix, n);
        movePrefixTable(prefix, n);
        int i = 0, j = 0;

        //text[i], len(text) = m
        //pattern[j], len(pattern) = n
        while (i < m) {
            if (j == n - 1 && text.charAt(i) == pattern.charAt(j)) {
                System.out.println("Found pattern at " + (i - j));
                j = prefix[j];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;j++;
            } else {
                j = prefix[j];
                if (j == -1) {
                    i++;j++;
                }
            }
        }

    }

    private void prefixTable(String pattern, int[] prefix, int n) {
        prefix[0] = 0;
        int len = 0;
        int i = 1;
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                prefix[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = prefix[len - 1];
                } else {
                    prefix[i] = len;
                    i++;
                }
            }
        }
    }

    private void movePrefixTable(int[] prefix, int n) {
        for (int i = n - 1; i > 0; --i) {
            prefix[i] = prefix[i - 1]; 
        }
    }
}