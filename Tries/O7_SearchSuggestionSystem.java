import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O7_SearchSuggestionSystem {
    class Node {
        Node links[] = new Node[26];
        boolean flag = false;

        Node() {
        }

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }

        boolean isEnd() {
            return flag;
        }

        void setEnd() {
            flag = true;
        }

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }
    }

    class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        void insert(String str) {
            int n = str.length();
            Node temp = root;
            for (int i = 0; i < n; i++) {
                char ch = str.charAt(i);
                if (!temp.containsKey(ch)) {
                    temp.put(ch, new Node());
                }
                temp = temp.get(ch);
            }
            temp.setEnd();
        }

        boolean startsWith(String str) {
            int n = str.length();
            Node temp = root;
            for (int i = 0; i < n; i++) {
                char ch = str.charAt(i);
                if (!temp.containsKey(ch)) {
                    return false;
                }
                temp = temp.get(ch);
            }
            if (temp.isEnd())
                return true;
            return false;
        }

        void dfs(Node node, String pref, List<String> list) {
            if (list.size() == 3)
                return;
            if (node.isEnd())
                list.add(pref);
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (node.containsKey(ch)) {
                    dfs(node.get(ch), pref + ch, list);
                }
            }
        }

        List<String> getSuggestions(String str) {
            Node temp = root;
            for (char ch : str.toCharArray()) {
                if (!temp.containsKey(ch)) {
                    return new ArrayList<>();
                }
                temp = temp.get(ch);
            }
            List<String> list = new ArrayList<>();
            dfs(temp, str, list);
            return list;
        }
    }

    class Solution {
        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            List<List<String>> res = new ArrayList<>();
            int n = products.length;
            Arrays.sort(products);
            Trie t = new Trie();
            for (int i = 0; i < n; i++) {
                t.insert(products[i]);
            }
            String pref = "";
            for (char ch : searchWord.toCharArray()) {
                pref += ch;
                List<String> list = t.getSuggestions(pref);
                res.add(list);
            }
            return res;
        }
    }
}
