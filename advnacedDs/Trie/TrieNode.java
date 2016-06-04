public class TrieNode{
	public TrieNode children[];
	boolean isLeaf;
	public TrieNode(){
		isLeaf = false;
		children = new TrieNode[26];
	}
}