package com.bins.question.tree;

/**
 * @author binLi
 * @date 2021/1/22 4:21 下午
 * @description 实现前缀树（字典树）
 * 来源：leetcode-208
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 **/
public class Trie {

    /**
     * 内部节点
     */
    public class TrieNode {
        private boolean isEnd;
        TrieNode[] next;

        public TrieNode() {
            isEnd = false;
            next = new TrieNode[26];
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * 插入
     */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    /**
     * 检索word是否存在于字典树中
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                return false;
            } else {
                node = node.next[c - 'a'];
            }
        }
        return node.isEnd;
    }

    /**
     * 检索字典树中是否有prefix开头的前缀
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                return false;
            } else {
                node = node.next[c - 'a'];
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
