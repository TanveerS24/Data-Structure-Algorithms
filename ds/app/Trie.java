package ds.app;

import ds.tree.TrieNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode('\0');
    }

    public void insert(String word){
        TrieNode current = root;
        for(char ch : word.toCharArray()){
            if(!current.getChildren().containsKey(ch)){
                current.getChildren().put(ch, new TrieNode(ch));
            }
            current = current.getChildren().get(ch);
        }
        current.setEndOfWord(true);
    }

    public boolean search(){
        return false;
    }

    public boolean delete(){
        return false;
    }

    public ArrayList<String> getAllWords(TrieNode root){
        ArrayList<String> words = new ArrayList<>();

        getAllWordsHelper(root, "", words);

        return words;

    }

    private void getAllWordsHelper(TrieNode node,String prefix, ArrayList<String> words){

        if(node.isEndOfWord() && !prefix.isEmpty()){
            words.add(prefix);
        }
        HashMap<Character, TrieNode> children = node.getChildren();
        for(char ch : children.keySet()){
            getAllWordsHelper(children.get(ch), prefix + ch, words);
        }

    }
    public static void main(String[] args){
        Trie trie = new Trie();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            String word = sc.next();
            trie.insert(word);
        }
        System.out.println("All words in the Trie:");
        trie.getAllWords(trie.root).forEach(System.out::println);
        sc.close();
    }
}
