/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    boolean checkBST(Node root) {
        boolean isBST = false;
        
        if (root != null){
            isBST = true;
            if (root.left != null){
                if (root.left.data >= root.data){
                    isBST = false;
                } else {
                    isBST = checkBST(root.left);
                }
            }
            if (root.right != null){
                if (root.right.data <= root.data){
                    isBST = false;
                } else {
                    boolean rBstCheck = checkBST(root.right);
                    if (rBstCheck==false || isBST==false){
                        isBST = false;
                    }
                }
            }
        }
        return isBST;
    }