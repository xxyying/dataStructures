package com.xxyying.algoFB;

class TrieNode{
	
	public boolean isWord;
	public TrieNode[] children = new TrieNode[26];
	public TrieNode() {}
}



public class Trie {
	private TrieNode root;
	
	/** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
        	char cur = word.charAt(i);
        	if(node.children[cur - 'a'] == null) {
        		node.children[cur - 'a'] = new TrieNode();
        	}
        	node = node.children[cur-'a'];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
        	char cur = word.charAt(i);
        	if(node.children[cur-'a'] == null) {
        		return false;
        	}
        	node = node.children[cur-'a'];
        }
        return node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++) {
        	char cur = prefix.charAt(i);
        	if(node.children[cur-'a'] == null) {
        		return false;
        	}
        	node = node.children[cur-'a'];
        }
        return true;
    }
    
    
	public static void main(String[] args) {
		Trie obj = new Trie();
		String word = "apple";
		String prefix = "app";
		obj.insert(word);
		boolean param_2 = obj.search(word);
		System.out.println(param_2);
		boolean param_3 = obj.startsWith(prefix);
		System.out.println(param_3);

	}

}
