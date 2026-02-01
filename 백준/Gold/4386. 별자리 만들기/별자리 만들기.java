import java.io.*;
import java.util.*;

public class Main {

    static class XY {
        float x;
        float y;

        public XY (float x, float y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge {
        int startId;
        int endId;
        float cost;

        public Edge(int startId, int endId, float cost) {
            this.startId = startId;
            this.endId = endId;
            this.cost = cost;
        }
    }

    static int N;
    static XY[] coorArr;
    static int[] parent;
    static List<Edge> list = new ArrayList<>();
    static HashMap<Integer, XY> map = new HashMap<>();
    static int[] tmpArr = new int[2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        coorArr = new XY[N+1];
        for (int i = 1; i <= N; i++) {
            String[] coorInput = br.readLine().split(" ");
            Float x = Float.parseFloat(coorInput[0]);
            Float y = Float.parseFloat(coorInput[1]);

            XY tmp = new XY(x, y);
            coorArr[i] = tmp;
            map.put(i, tmp);
        }

        comb(1, 0);

        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        Collections.sort(list, (o1, o2) -> Float.compare(o1.cost, o2.cost));

        int count = 0;
        float mstWeight = 0;

        for (Edge edge : list) {
            if (find(edge.startId) != find(edge.endId)) {
                union(edge.startId, edge.endId);
                count++;
                mstWeight += edge.cost;
                if (count == N-1) break;
            }
        }

        System.out.println(Math.round(mstWeight * 100) / 100.0);
    }

    static void comb(int start, int depth) {
        if (depth == 2) {
            int firstId = tmpArr[0];
            int secondId = tmpArr[1];

            float length = calculateStarLength(map.get(firstId), map.get(secondId));
            list.add(new Edge(firstId, secondId, length));
            return;
        }

        for (int i = start; i < coorArr.length; i++) {
            tmpArr[depth] = i;
            comb(i+1, depth+1);
        }
    }

    static float calculateStarLength(XY first, XY second) {
        return (float) Math.sqrt(Math.pow((second.x - first.x), 2) + Math.pow((second.y - first.y), 2));
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int nx = find(x);
        int ny = find(y);

        if (nx < ny) parent[ny] = nx;
        else parent[nx] = ny;
    }
}


