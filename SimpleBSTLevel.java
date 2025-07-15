class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}

public class SimpleBSTLevel {

    // Insert a value into the Binary Search Tree
    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);
        return root;
    }

    // Print all nodes at the given level
    static void printLevel(Node root, int level) {
        if (root == null) return;

        if (level == 0) {
            System.out.print(root.val + " ");
            return;
        }

        printLevel(root.left, level - 1);
        printLevel(root.right, level - 1);
    }

    // Optional: Compute height of tree
    static int height(Node root) {
        if (root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
        int[] values = {8, 3, 10, 9, 1, 6, 14, 4, 7, 13};
        Node root = null;

        // Insert values into BST
        for (int val : values) {
            root = insert(root, val);
        }

        int level = 3;  // Change this to print a different level
        System.out.println("Nodes at level " + level + ":");
        printLevel(root, level);
    }
}





