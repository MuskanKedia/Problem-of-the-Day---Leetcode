class TrieNode{
    boolean isWord;
    TrieNode [] chdn = new TrieNode[26]; 
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode tn = root;
        for(char c:word.toCharArray()){
            int i = c-'a';
            if(tn.chdn[i] == null)
                tn.chdn[i] = new TrieNode();
            tn = tn.chdn[i];
        }
        tn.isWord = true;
    }
    
    public boolean search(String word) {
        return sc(word.toCharArray(),0,root);
    }
    private boolean sc(char[] ca, int st, TrieNode tn){
        if (st == ca.length) return tn.isWord;
        if(ca[st]=='.') {
            for(int j=0;j<26;j++)
                if(tn.chdn[j]!= null && sc(ca,st+1,tn.chdn[j])) return true;
            return false;
        }
        int i = ca[st]-'a';
        if(tn.chdn[i] == null) return false;
        return sc(ca,st+1,tn.chdn[i]);
    }
}

//Time Complexity : O(L*N)
//Space Complexity : O(L*N)
