public class O1_ImplementTrie {
    public class Node {
        Node links[] = new Node[26];
        boolean flag = false;

        Node() {
        }

        boolean containsKey(char ch) {
            if (links[ch - 'a'] != null) {
                return true;
            }
            return false;
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        void setEnd() {
            flag = true;
        }

        boolean isEnd() {
            return flag;
        }
    }

    class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node temp = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!temp.containsKey(ch)) {
                    temp.put(ch, new Node());
                }
                temp = temp.get(ch);
            }
            temp.setEnd();
        }

        public boolean search(String word) {
            int n = word.length();
            Node temp = root;
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                if (!temp.containsKey(ch)) {
                    return false;
                }
                temp = temp.get(ch);
            }
            if (temp.isEnd())
                return true;
            return false;
        }

        public boolean startsWith(String word) {
            int n = word.length();
            Node temp = root;
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                if (!temp.containsKey(ch)) {
                    return false;
                }
                temp = temp.get(ch);
            }
            return true;
        }
    }
}
