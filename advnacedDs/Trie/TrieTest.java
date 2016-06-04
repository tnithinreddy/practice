public class TrieTest{
	public static void main(String[] args) {
		Trie dict = new Trie();
		dict.insert("the");
		dict.insert("cater");
		dict.insert("their");
		dict.insert("cat");
		System.out.println(dict.search("c"));
		// String s = "Hello";
		// System.out.println(((int)'a') - 97);
	}
}