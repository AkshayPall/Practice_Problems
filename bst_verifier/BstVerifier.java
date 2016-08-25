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
        
        value = value+","+root.data;
        
        if(root.right != null){
            value = inOrder(root.right, value);
        }

        return value;
    }

    boolean verifyNodes (String string){
        boolean isBst = true;

        boolean complete = false;
        for (int i = 1; i < string.length() && complete == false; i++){

        		//to find previous int
            int prevStart = i;

            //to find current int
            int currStart = i;

            //actual previous and current int values
            boolean firstIndex = true;
           	int previous = 0;
           	int curr = 0;


           	//finding current index - i should already be at the start
           	while (i < string.length() && string.charAt(i) != ','){
           		i++;
           	}
           	//found end of int
           	curr = Integer.parseInt(string.substring(currStart, i));

           	//finding previous index
           	if (currStart > 1){
           		firstIndex = false;
           		currStart--; //this is used as the end of the previous index
           		prevStart-=2;
           		while (prevStart >= 0 && string.charAt(prevStart) != ','){
           			prevStart--; //to find start of previous index
           		}

           		previous = Integer.parseInt(string.substring(prevStart+1, currStart));
           	}


            if (!firstIndex && previous >= curr){
                isBst = false;
                complete = true;
            }
        }

        return isBst;
    }