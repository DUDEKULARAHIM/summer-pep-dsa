// class Node {
//     int val;
//     Node left, right;

//     Node(int val) {
//         this.val = val;
//     }
// }

// public class tree_problems {

//     // Insert a value into the Binary Search Tree
//     static Node insert(Node root, int val) {
//         if (root == null) return new Node(val);
//         if (val < root.val)
//             root.left = insert(root.left, val);
//         else
//             root.right = insert(root.right, val);
//         return root;
//     }

//     // Print only leaf nodes (nodes with no children)
//     static void printLeafNodes(Node root) {
//         if (root == null) return;

//         if (root.left == null && root.right == null) {
//             System.out.print(root.val + " ");
            
//         }

//         if(root.left!=null)
//             printLeafNodes(root.left);
//         if(root.right!=null)
//             printLeafNodes(root.right);
//     }

//     public static void main(String[] args) {
//         int[] values = {8, 3, 10, 9, 1, 6, 14, 4, 7, 13};
//         Node root = null;

//         // Build the BST
//         for (int val : values) {
//             root = insert(root, val);
//         }

//         // Print all leaf nodes
//         System.out.println("Leaf nodes in the BST:");
//         printLeafNodes(root);
//     }
// }



public class tree_problems{
    public static void main(String[] args) {
        
    }
}