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

            int previous = 0;
            int curr = 0;

            //check for possible negative integer
            if (string.charAt(i-1) == '-') {
                previous = Integer.parseInt(string.substring(i-1, i+1));
                i++;
            } else {
                previous = string.charAt(i-1)-0;
            }

            //check for possible negative integer
            if(string.charAt(i) == '-'){
                curr = Integer.parseInt(string.substring(i,i+2));
                i++;
            } else {
                curr = string.charAt(i)-0;
            }


            if (previous >= curr){
                isBst = false;
                complete = true;
            }
        }

        return isBst;
    }