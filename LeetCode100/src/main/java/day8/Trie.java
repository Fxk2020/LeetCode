package day8;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 */
class Trie {

    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];//26个字母
        isEnd = false;
    }

    public void insert(String word) {
        char[] str = word.toCharArray();
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = str[i] - 'a';
            if (node.children[index] == null){
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {

        Trie node = searchPrefix(word);
        return node!=null&&node.isEnd;
    }

    public boolean startsWith(String prefix) {

        return searchPrefix(prefix)!=null;

    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

}