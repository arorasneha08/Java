public class O2_ImplementTrieII {
    public class Trie {
        public class Node {
            Node links[] = new Node[26];
            int countPrefix = 0;
            int countEndsWith = 0;

            Node() {
            }

            boolean containsKey(char ch) {
                return (links[ch - 'a'] != null);
            }

            Node get(char ch) {
                return links[ch - 'a'];
            }

            void put(char ch, Node node) {
                links[ch - 'a'] = node;
            }

            void increasePrefix() {
                countPrefix++;
            }

            void increaseEnd() {
                countEndsWith++;
            }

            void deleteEnd() {
                countEndsWith--;
            }

            void reducePrefix() {
                countPrefix--;
            }

            int getEnd() {
                return countEndsWith;
            }

            int getPrefix() {
                return countPrefix;
            }
        }

        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node temp = root;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                if (!temp.containsKey(ch)) {
                    temp.put(ch, new Node());
                }
                temp = temp.get(ch);
                temp.increasePrefix();
            }
            temp.increaseEnd();
        }

        public int countWordsEqualTo(String word) {
            Node temp = root;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                if (!temp.containsKey(ch)) {
                    return 0;
                }
                temp = temp.get(ch);
            }
            return temp.getEnd();
        }

        public int countWordsStartingWith(String word) {
            Node temp = root;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                if (!temp.containsKey(ch)) {
                    return 0;
                }
                temp = temp.get(ch);
            }
            return temp.getPrefix();
        }

        public void erase(String word) {
            int n = word.length();
            Node temp = root;
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                if (temp.containsKey(ch)) {
                    temp = temp.get(ch);
                    temp.reducePrefix();
                }
            }
            temp.deleteEnd();
        }
    }
}
