import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // read 1 line from standard input
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        // make tree data structure
        Map<String, ArrayList<String>> tree = new HashMap<>();
        // parse tree data structure
        parseTree(sc, tree, n);
        // traverse the tree in pre-order
        preOrder(tree, "A");
        System.out.println();
        // traverse the tree in in-order
        inOrder(tree, "A");
        System.out.println();
        // traverse the tree in post-order
        postOrder(tree, "A");
    }
    static void parseTree(java.util.Scanner sc, Map<String, ArrayList<String>> tree, int n) {
        // read n lines of node and parse the tree data structure
        // 3 part of the input: parent, left child, right child
        tree.put("A", new ArrayList<>());
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            String parent = input[0];
            String leftChild = input[1];
            String rightChild = input[2];
            // add the left and right child nodes to the parent node
            tree.get(parent).addAll(Arrays.asList(leftChild, rightChild));
            // add the left and right child nodes to the tree
            for (String child: Arrays.asList(leftChild, rightChild)) {
                if (!tree.containsKey(child) && !child.equals(".")) {
                    tree.put(child, new ArrayList<>());
                }
            }
        }
    }
    static void preOrder(Map<String, ArrayList<String>> tree, String node) {
        // print the node in pre-order
        System.out.print(node);
        // traverse the left child node
        if (!tree.get(node).get(0).equals(".")) {
            preOrder(tree, tree.get(node).get(0));
        }
        // traverse the right child node
        if (!tree.get(node).get(1).equals(".")) {
            preOrder(tree, tree.get(node).get(1));
        }
    }
    static void inOrder(Map<String, ArrayList<String>> tree, String node) {
        // traverse the left child node
        if (!tree.get(node).get(0).equals(".")) {
            inOrder(tree, tree.get(node).get(0));
        }
        // print the node in in-order
        System.out.print(node);
        // traverse the right child node
        if (!tree.get(node).get(1).equals(".")) {
            inOrder(tree, tree.get(node).get(1));
        }
    }
    static void postOrder(Map<String, ArrayList<String>> tree, String node) {
        // traverse the left child node
        if (!tree.get(node).get(0).equals(".")) {
            postOrder(tree, tree.get(node).get(0));
        }
        // traverse the right child node
        if (!tree.get(node).get(1).equals(".")) {
            postOrder(tree, tree.get(node).get(1));
        }
        // print the node in post-order
        System.out.print(node);
    }
}
