package hard7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词搜索ii
 **/
public class WordSearchii {

    private Set<String> ans;
    private Trie trie;

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0].length == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        ans = new HashSet<>();
        trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, "", trie.root);
            }
        }

        return new ArrayList<>(ans);
    }

    private void dfs(char[][] board, int i, int j, String path, Trie.TrieNode root) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '@') {
            return;
        }

        path += board[i][j];

        if (root.containKey(board[i][j])) {
            char key = board[i][j];
            board[i][j] = '@';
            Trie.TrieNode node = root.get(key);
            if (node.isEnd) {
                ans.add(path);
            }
            dfs(board, i + 1, j, path, node);
            dfs(board, i - 1, j, path, node);
            dfs(board, i, j + 1, path, node);
            dfs(board, i, j - 1, path, node);
            board[i][j] = key;
        }
    }

    class Trie {


        public TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.containKey(ch)) {
                    node = node.get(ch);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.put(ch, newNode);
                    node = newNode;
                }
            }
            node.setEnd(true);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                node = node.get(ch);
                if (node == null) {
                    break;
                }
            }
            return node != null && node.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                node = node.get(ch);
                if (node == null) {
                    break;
                }
            }
            return node != null;
        }


        class TrieNode {

            private final int R = 26;

            private TrieNode[] links;

            private boolean isEnd;

            public TrieNode() {
                this.links = new TrieNode[R];
            }

            public boolean containKey(char ch) {
                return links[ch - 'a'] != null;
            }

            public TrieNode get(char ch) {
                return links[ch - 'a'];
            }

            public void put(char ch, TrieNode node) {
                links[ch - 'a'] = node;
            }

            public boolean isEnd() {
                return isEnd;
            }

            public void setEnd(boolean end) {
                isEnd = end;
            }
        }
    }
}
