import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        StringBuilder coinSerialization;
        int count;

        public Node(StringBuilder coinSerialization, int count) {
            this.coinSerialization = coinSerialization;
            this.count = count;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            // 동전 배열을 문자열로 직렬화하여 처리
            StringBuilder coinSerialization = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                String[] input = br.readLine().split(" ");
                coinSerialization.append(input[0]).append(input[1]).append(input[2]);
            }

            Node start = new Node(coinSerialization, 0);
            System.out.println(bfs(start));
        }
    }

    static int bfs(Node start) {
        Queue<Node> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        q.add(start);
        visited.add(start.coinSerialization.toString());

        boolean sameCoinFlip = false;
        int count = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            // 모두 같은 면인지 체크하는 로직
            if (checkSameFlip(now.coinSerialization.toString())) {
                sameCoinFlip = true;
                count = now.count;
                break;
            }

            for (int i = 0; i < 8; i++) {
                StringBuilder nextCoinSerialization = flip(now.coinSerialization, i);

                if (!visited.contains(nextCoinSerialization.toString())) {
                    visited.add(nextCoinSerialization.toString());
                    q.add(new Node(nextCoinSerialization, now.count + 1));
                }
            }
        }

        if (sameCoinFlip) {
            return count;
        } else {
            return -1;
        }
    }

    static boolean checkSameFlip(String coinSerialization) {
        char firstCoin = coinSerialization.charAt(0);
        boolean sameFlip = true;

        for(char ch : coinSerialization.toCharArray()) {
            if (firstCoin != ch) {
                sameFlip = false;
                break;
            }
        }

        return sameFlip;
    }

    static StringBuilder flip(StringBuilder coinSerialization, int flipType) {
        StringBuilder flipCoinSerialization = new StringBuilder();

        // 0행을 뒤짚는 연산
        if (flipType == 0) {
            for (int i = 0; i < 3; i++) {
                if (coinSerialization.charAt(i) == 'H') {
                    flipCoinSerialization.append('T');
                } else {
                    flipCoinSerialization.append('H');
                }
            }

            flipCoinSerialization.append(coinSerialization.substring(3, 9));
        }

        // 1행을 뒤짚는 연산
        if (flipType == 1) {
            flipCoinSerialization.append(coinSerialization.substring(0, 3));
            for (int i = 3; i < 6; i++) {
                if (coinSerialization.charAt(i) == 'H') {
                    flipCoinSerialization.append('T');
                } else {
                    flipCoinSerialization.append('H');
                }
            }

            flipCoinSerialization.append(coinSerialization.substring(6, 9));
        }

        // 2행을 뒤짚는 연산
        if (flipType == 2) {
            flipCoinSerialization.append(coinSerialization.substring(0, 6));
            for (int i = 6; i < 9; i++) {
                if (coinSerialization.charAt(i) == 'H') {
                    flipCoinSerialization.append('T');
                } else {
                    flipCoinSerialization.append('H');
                }
            }
        }

        // 0열을 뒤짚는 연산
        if (flipType == 3) {
            for (int i = 0; i < 9; i++) {
                if (i % 3 == 0) {
                    if (coinSerialization.charAt(i) == 'H') {
                        flipCoinSerialization.append('T');
                    } else {
                        flipCoinSerialization.append('H');
                    }
                } else {
                    flipCoinSerialization.append(coinSerialization.charAt(i));
                }
            }
        }

        // 1열을 뒤짚는 연산 (1, 4, 7)
        if (flipType == 4) {
            for (int i = 0; i < 9; i++) {
                if (i % 3 == 1) {
                    if (coinSerialization.charAt(i) == 'H') {
                        flipCoinSerialization.append('T');
                    } else {
                        flipCoinSerialization.append('H');
                    }
                } else {
                    flipCoinSerialization.append(coinSerialization.charAt(i));
                }
            }
        }

        // 2열을 뒤짚는 연산
        if (flipType == 5) {
            for (int i = 0; i < 9; i++) {
                if (i % 3 == 2) {
                    if (coinSerialization.charAt(i) == 'H') {
                        flipCoinSerialization.append('T');
                    } else {
                        flipCoinSerialization.append('H');
                    }
                } else {
                    flipCoinSerialization.append(coinSerialization.charAt(i));
                }
            }
        }

        // 오른쪽으로 이어지는 대가선으로 뒤짚는 연산
        if (flipType == 6) {
            for (int i = 0; i < 9; i++) {
                if (i == 0 || i == 4 || i == 8) {
                    if (coinSerialization.charAt(i) == 'H') {
                        flipCoinSerialization.append('T');
                    } else {
                        flipCoinSerialization.append('H');
                    }
                } else {
                    flipCoinSerialization.append(coinSerialization.charAt(i));
                }
            }
        }

        // 왼쪽으로 이어지는 대가선으로 뒤짚는 연산
        if (flipType == 7) {
            for (int i = 0; i < 9; i++) {
                if (i == 2 || i == 4 || i == 6) {
                    if (coinSerialization.charAt(i) == 'H') {
                        flipCoinSerialization.append('T');
                    } else {
                        flipCoinSerialization.append('H');
                    }
                } else {
                    flipCoinSerialization.append(coinSerialization.charAt(i));
                }
            }
        }
        return flipCoinSerialization;
    }
}