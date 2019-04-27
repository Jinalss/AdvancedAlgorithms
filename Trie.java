class TrieNode{
    TrieNode[] child = new TrieNode[26];

    boolean isEnd;
    boolean isParent;

    TrieNode(){
        isEnd = false;
        isParent = false;
        for (int i = 0; i < 26; i++)
            child[i] = null;
    }
};

public class Trie {

    static TrieNode root;

    static void insert(String word){
        TrieNode node = root;
        char[] letters = word.toCharArray();
        for (char ch : letters){
            int id = ch - 'a';
            if (node.child[id] == null)
                node.child[id] = new TrieNode();
            node.isParent = true;
            node = node.child[id];
        }
        node.isEnd = true;
    }

    static TrieNode search(String word){
        TrieNode node = root;
        char[] letters = word.toCharArray();
        for (char ch : letters){
            int id = ch - 'a';
            if (node.child[id] == null)
                return null;
            node = node.child[id];
        }
        return node;
    }

    static void suggestWords(String text, TrieNode t){
        if(t.isEnd){
            System.out.println(text);
        }
        String suggest = text;
        for (int i = 0; i < 26; i++) {
            if (t.child[i] != null){
                suggestWords(text+((char) (i+'a')), t.child[i]);
            }
        }
    }

    public static void main(String args[]){
        String dict[] = {"help","hello","dog","hell","cat","a","helpful"};

        root = new TrieNode();

        for (String word : dict)
            insert(word);

        String textToSearch = "hel";
        TrieNode node = search(textToSearch);
        boolean autoSuggest = false;
        if (node!=null) {
            suggestWords(textToSearch, node);
            autoSuggest = true;
        }

        if (!autoSuggest){
            System.out.println("No strings for the given text");
        }

    }
}