class Node {
    private Node[] links;
    private boolean flag = false;
    public Node() {
        links = new Node[26];
    }
    public boolean containsKey(char c) {
        return links[c - 'a'] != null;
    }
    public void put(char c, Node node) {
        links[c - 'a'] = node;
        return;
    }
    public Node get(char c) {
        return links[c - 'a'];
    }
    public boolean isEnd() {
        return flag;
    }
    public void setEnd() {
        flag = true;
    }
}
class Trie {
    private Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++) {
            if(!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i),new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++) {
            if(!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i = 0; i < prefix.length(); i++) {
            if(!node.containsKey(prefix.charAt(i))) {
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
}
