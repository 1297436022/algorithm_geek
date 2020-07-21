package chapter12;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;


class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit",
               endWord = "cog";
        List<String> wordList = new ArrayList<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        //wordList.add("cog");
        WordLadder wl = new WordLadder();
        System.out.println(wl.ladderLength1(beginWord, endWord, wordList));
    }

    //双向BFS
    //ladderLength1超时
    //图解: https://leetcode-cn.com/problems/word-ladder/solution/dan-ci-jie-long-by-leetcode/
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> beginSet = new HashSet<String>(), 
                    endSet = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }
                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = temp;
            len++;
        }
        return 0;
    }

    //通过
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList), 
                    qs = new HashSet<>(), 
                    qe = new HashSet<>(), 
                    vis = new HashSet<>();
        qs.add(beginWord);
        if (dict.contains(endWord)) {
            qe.add(endWord); // all transformed words must be in dict (including endWord)
        }
        for (int len = 2; !qs.isEmpty(); len++) {
            Set<String> nq = new HashSet<>();
            for (String w : qs) {
                for (int j = 0; j < w.length(); j++) {
                    char[] ch = w.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == w.charAt(j)) 
                            continue; // beginWord and endWord not the same, so bypass itself
                        ch[j] = c;
                        String nb = String.valueOf(ch);
                        if (qe.contains(nb)) 
                            return len; // meet from two ends
                        if (dict.contains(nb) && vis.add(nb)) 
                            nq.add(nb); // not meet yet, vis is safe to use
                    }
                }
            }
            qs = (nq.size() < qe.size()) ? nq : qe; // switch to small one to traverse from other end
            qe = (qs == nq) ? qe : nq;
        }
        return 0;
    }
}