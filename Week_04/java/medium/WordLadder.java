package medium;

import java.util.*;

/**
 * 单词接龙
 * @since
 **/
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        return bfs(beginWord, endWord, wordList);
        return bfs2(beginWord, endWord, wordList);
    }

    /**
     * 广度优先bfs
     * 时间复杂度 O(M*N) M为单词等长度，N为wordList的大小
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    private int bfs(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        wordSet.remove(beginWord);
        Deque<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int count = 1;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.pollFirst();
                for (int j = 0; j < cur.length(); j++) {
                    for (int k = 0; k < 26; k++) {
                        String newLadder = genNextWord(cur, j, k + 'a');
                        if (wordSet.remove(newLadder)) {
                            if (newLadder.equals(endWord)) {
                                return count;
                            }
                            queue.addLast(newLadder);
                        }
                    }
                }
            }
        }
        return 0;
    }

    private String genNextWord(String cur, int i, int newChar) {
        char[] chars = cur.toCharArray();
        chars[i] = (char) newChar;
        return String.valueOf(chars);
    }

    /**
     * 双向广度优先遍历
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    private int bfs2(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();

        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);

        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);

        int step = 1;
        int len = beginWord.length();

        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            // 优先选择小的集合进行扩散
            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }

            Set<String> nextLevelVisited = new HashSet<>();
            for (String cur : beginVisited) {
                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < 26; j++) {
                        String nextWord = genNextWord(cur, i, 'a' + j);
                        if (!wordSet.contains(nextWord)) {
                            continue;
                        }
                        if (endVisited.contains(nextWord)) {
                            return step + 1;
                        } else if (visited.add(nextWord)){
                            nextLevelVisited.add(nextWord);
                        }
                    }
                }
            }
            beginVisited = nextLevelVisited;
            step++;
        }

        return 0;
    }

    public static void main(String[] args) {
        int i = new WordLadder().ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(i);
    }
}
