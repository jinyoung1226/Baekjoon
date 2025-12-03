import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int v;
        Node left;
        Node right;

        public Node(int v) {
            this.v = v;
        }

        void insert(int n) {
            if (n < this.v) {
                if (this.left == null) {
                    this.left = new Node(n);
                } else {
                    this.left.insert(n);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(n);
                } else {
                    this.right.insert(n);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int f = Integer.parseInt(br.readLine());
        Node root = new Node(f);


        while (true) {
            String s = br.readLine();
            if (s == null || s.equals("")) {
                break;
            }
            int n = Integer.parseInt(s);
            root.insert(n);
        }

        postOrder(root);
    }

    static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.v);
    }
}