public class Trie{
	public TrieNode root;
	public Trie(){
		root = new TrieNode();
	}
	// insert
	public void insert(String s){
		int length = s.length();
		s = s.toLowerCase();
		TrieNode crawler = root;
		int index ;
		for (int i =0;i< length ;i++ ) {
			index = getIndex(s.charAt(i));
			if (crawler.children[index] == null) {
				crawler.children[index] = new TrieNode();
			}
			crawler = crawler.children[index];
		}
		crawler.isLeaf = true;
	}
	// delete
	// search
	public int search(String s){
		int length = s.length();
		s = s.toLowerCase();
		TrieNode crawler = root;
		int index;
		for ( int i = 0;i<length ; i++ ) {
			index = getIndex(s.charAt(i));
			if (crawler.children[index]==null) {
				return -1;
			}
			crawler = crawler.children[index];
		}
		if (crawler!=null && crawler.isLeaf) {
			return 1;
		}
		return -1;
	}
	public int getIndex(char c){
		int x = (int)c;
		return (x - 97);
	}
	// get prefix
	public String prefix(String s){
		int length = s.length();
		TrieNode crawler = root;
		int index;
		for (int i =0; i< length ; i++) {
			index = getIndex(s.charAt(i));
			if (crawler==null || crawler.children[index]==null) {
				return null;
			}
		}
	}
}