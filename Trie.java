// Java implementation of search and insert operations
// on Trie
public class Trie {

    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;

    // trie node
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;
        boolean isParent;

        TrieNode(){
            isEndOfWord = false;
            isParent = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    };

    static TrieNode root;

    // If not present, inserts key into trie
    // If the key is prefix of trie node, 
    // just marks leaf node
    static void insert(String key)
    {
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl.isParent = true;
            pCrawl = pCrawl.children[index];
        }

        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }

    // Returns true if key presents in trie, else false
    static TrieNode search(String key)
    {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';

            if (pCrawl.children[index] == null)
                return null;

            pCrawl = pCrawl.children[index];
        }

        //return (pCrawl != null && pCrawl.isEndOfWord);
        return pCrawl;
    }

    static void suggestWords(String prefix, TrieNode t){
        if(t.isEndOfWord){
            System.out.println(prefix);
        }
        String suggest = prefix;
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (t.children[i] != null){
                suggestWords(prefix+((char) (i+'a')), t.children[i]);
            }
        }
    }

    static  int printAutoSuggestions(String prefix){

        TrieNode pCrawl = search(prefix);
        if (pCrawl!=null){


            suggestWords(prefix,pCrawl);
            return 1;


        }
        return -1;
    }

    // Driver
    public static void main(String args[])
    {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"help","hello","dog","hell","cat","a","helpful"};

        String output[] = {"Not present in trie", "Present in trie"};


        root = new TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
            insert(keys[i]);

        //auto suggest
        int comp = printAutoSuggestions("hel");
        if (comp == -1){
            System.out.println("No strings with the prefix found");
        }

    }
}