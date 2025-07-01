
// Node : the fundemantal part of binary tree , which cintains data and link to left and right child
// Root : the top most node in the tree which has no parent
// Parent Node : A node that has 
// Child node :
// Internal node : 

// Properties of binary tree :
// The maximum number of nodes at level L of binary tree can be 2 power L.
// level L starts from 0;
// Maximum number of nodes in binary tree of hight H = 2 power (h+1) -1

// Basic Operation on binary tree :
// Insert the node
// Delete the Node
// search the node
// Traverse the Node
// Modify / update the node


Binary Search Tree :
Left node should be always less than the root node
Right node should always grater than the root node



public class tree {
    LevelOrder(Node temp){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int levelsize = q.size();
            for(int i=0;i<levelsize;i++){
                Node tempnode = queue.poll();
                System.out.println(tempnode.data);

                if(tempnode.left!=null){
                    q.add(tempnode.left);
                }
                 if(tempnode.right!=null){
                    q.add(tempnode.right);
                }
            }
            }
        }
    }

   public static void main(String[] args){
    root = new Node();
    while(!q.isEmpty()){
        Node temp =q.poll();

    }
   }

}



// bst

Node insert(Node root,int data){
    if(root==null){
        return (new Node(data));
    }
    if(data<root.data){
        root.left = insert(root.left,data);
    }els{
        root.right = insert(root.right,data);
    }
    return root;
}

Boolean search (Node root,int key){
    if(root==null){
        return false;
    }
    if(root.data == key){
        return true;
    }
    return (root.data<key)?search(root.left,key):search(root.right,key);
}



Node delete(Node root,int key){
    
}
