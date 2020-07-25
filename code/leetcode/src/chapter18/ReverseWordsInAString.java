package chapter18;

import java.util.Arrays;

import java.util.Collections;

class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +"); //可以多个空格
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }    
}