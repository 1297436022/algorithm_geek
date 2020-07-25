package chapter18;

class ReverseString {
    public void reverseString(char[] s) {
        if (s == null) {
            return;
        } 
        for (int i = 0, j = s.length - 1; i < j; ++i, --j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }

        //for (int i = 0; i < a.length - 1; ++i) {
        //    for(int j = i + 1; j < a.length; ++j)    
        //}
    }
    
}