import java.io.*;
import java.util.*;

public class Main {

    static class Document {
        int idx;
        int important;

        public Document(int idx, int important) {
            this.idx = idx;
            this.important = important;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] data = br.readLine().split(" ");
            int N = Integer.parseInt(data[0]);
            int M = Integer.parseInt(data[1]);
            String[] document = br.readLine().split(" ");

            Queue<Document> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            int count = 0;
            for (int j = 0; j < N; j++) {
                q.add(new Document(j, Integer.parseInt(document[j])));
                pq.add(Integer.parseInt(document[j]));
            }

            while (!q.isEmpty()) {
                Document doc = q.poll();

                if (doc.important == pq.peek()) {
                    pq.poll();
                    count++;
                    if (M == doc.idx) {
                        System.out.println(count);
                        break;
                    }
                } else {
                    q.add(doc);
                }
            }


        }
    }
}