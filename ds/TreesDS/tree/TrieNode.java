package TreesDS.tree;

import java.util.HashMap;

public class TrieNode {
    private char data;
    private boolean isEndOfWord;
    private HashMap<Character, TrieNode> children;

    public TrieNode(char data) {
        this.data = data;
        this.isEndOfWord = false;
        this.children = new HashMap<>();
    }

    public char getData() {
        return data;
    }
    public void setData(char data) {
        this.data = data;
    }
    public boolean isEndOfWord() {
        return isEndOfWord;
    }
    public void setEndOfWord(boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;
    }
    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }
}
