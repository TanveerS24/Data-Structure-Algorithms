package TreesDS.app;

import TreesDS.tree.TrieNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

@SuppressWarnings("unused")
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

    public boolean search(String word){
        TrieNode current = root;
        for(char ch:word.toCharArray()){
            if(!current.getChildren().containsKey(ch)){
                return false;
            }
            current = current.getChildren().get(ch);
        }
        return current.isEndOfWord();
    }

    public void delete(String word){
        if(!search(word)){
            System.out.println("Word not found in Trie.");
            return;
        }

        deleteHelper(root, word, 0);
        System.out.println("Word deleted successfully.");
    }

    private boolean deleteHelper(TrieNode current, String word, int index){
        if(index == word.length()){
            if(!current.isEndOfWord()){
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if(node == null){
            return false;
        }
        boolean shouldDeleteCurrentNode = deleteHelper(node, word, index + 1);

        if(shouldDeleteCurrentNode){
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty() && !current.isEndOfWord();
        }
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
        // Trie trie = new Trie();
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // for(int i = 0; i < n; i++){
        //     String word = sc.next();
        //     trie.insert(word);
        // }
        // System.out.println("All words in the Trie:");
        // trie.getAllWords(trie.root).forEach(System.out::println);
        // System.out.println("Enter a word to search:");
        // String searchWord = sc.next();
        // if(trie.search(searchWord)){
        //     System.out.println("Word found.");
        // } else {
        //     System.out.println("Word not found.");
        // }
        // System.out.println("Enter a word to delete:");
        // String deleteWord = sc.next();
        // trie.delete(deleteWord);
        // System.out.println("All words in the Trie after deletion:");
        // trie.getAllWords(trie.root).forEach(System.out::println);
        
        // sc.close();
    }
}
