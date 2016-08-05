/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    boolean checkBST(Node root) {        

        if (root == null){
            return true;
        } else {
            String nodes = inOrder(root, "");

            return verifyNodes(nodes);
        }

    }

    String inOrder(Node root, String value){

        if (root.left != null){
            value = inOrder (root.left, value);
        }
        
        value = value+root.data;
        
        if(root.right != null){
            value = inOrder(root.right, value);
        }

        return value;
    }

    boolean verifyNodes (String string){
        boolean isBst = true;

        boolean complete = false;
        for (int i = 1; i < string.length() && complete == false; i++){
            if (string.charAt(i-1)>=string.charAt(i)){
                isBst = false;
                complete = true;
            }
        }

        return isBst;
    }