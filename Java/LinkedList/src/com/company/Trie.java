package com.company;

public class Trie {
    Node root;

    public Trie() {
        root = new Node('\0');
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println("Insert cardinal, card, and car");
        trie.insert("cardinal");
        trie.insert("card");
        trie.insert("car");
        System.out.println("Search for car; result: " + trie.search("car"));
        System.out.println("Search for cars; result: " + trie.search("cars"));
        System.out.println("Search for empty string; result: " + trie.search(""));
    }

    public void insert(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new Node(c);
            }
            current = current.children[index];
        }
        current.isWord = true;
    }

    private Node getNode(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (current.children[index] == null) {
                return null;
            }
            current = current.children[index];
        }
        return current;
    }

    public boolean search(String word) {
        Node node = getNode(word);
        return node != null && node.isWord;
    }

    boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    class Node {
        char c;
        boolean isWord;
        Node[] children;

        public Node(char c) {
            this.c = c;
            isWord = false;
            children = new Node[26];
        }
    }
}
