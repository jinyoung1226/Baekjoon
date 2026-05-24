import java.util.*;

class Solution {
    boolean[] visited;
    class Word {
        String word;
        int count;
        
        public Word (String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        int answer = bfs(begin, target, words);
        return answer;
    }
    
    public int bfs(String begin, String target, String[] words) {
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin, 0));
        
        while(!q.isEmpty()) {
            Word now = q.poll();
            
            if (now.word.equals(target)) {
                return now.count;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i]) {
                    int check = 0;
                    for (int j = 0; j < words[i].length(); j++) {
                        if (words[i].charAt(j) != now.word.charAt(j)) {
                            check++;
                        }
                    }
                    
                    if (check == 1) {
                        visited[i] = true;
                        q.add(new Word(words[i], now.count + 1));
                    }
                }
            }
        }
        return 0;
    }
}