import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        char v;
        Node left, right;

        public Node (char v, Node left, Node right) {
            this.v = v;
            this.left = left;
            this.right = right;
        }
    }

    static int N;
    static Node[] tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new Node[26];

        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            char root = data[0].charAt(0);
            char left = data[1].charAt(0);
            char right = data[2].charAt(0);

            if (tree[root - 'A'] == null) {
                tree[root - 'A'] = new Node(root, null, null);
            }
            Node node = tree[root - 'A'];

            if (left != '.') {
                if (tree[left - 'A'] == null) {
                    tree[left - 'A'] = new Node(left, null, null);
                }
                node.left = tree[left - 'A'];
            }

            if (right != '.') {
                if (tree[right - 'A'] == null) {
                    tree[right - 'A'] = new Node(right, null, null);
                }
                node.right = tree[right - 'A'];
            }
        }

        preOrder(tree[0]);
        sb.append("\n");
        inOrder(tree[0]);
        sb.append("\n");
        postOrder(tree[0]);
        System.out.println(sb);

    }

    static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        sb.append(node.v);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        sb.append(node.v);
        inOrder(node.right);
    }

    static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.v);
    }
}