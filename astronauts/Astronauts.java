import java.io.*;
import java.util.*;

public class Astronauts {
   public static void main(String[] args) throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bfr.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int I = Integer.parseInt(temp[1]);

        ArrayList<Node> nodes = new ArrayList<Node>();
        for(int i = 0; i < I; i++){
            temp = bfr.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            //check if this node exists, if not then add to arraylist, else retrieve it
            Node B = new Node(b);
            int pos = findNode(a, nodes);
            if (pos == -1){
                Node A = new Node(a);
                A.addChild(B);
                nodes.add(A);
            } else {
                nodes.get(pos).addChild(B);
            }
            //remove b if in nodes
            int bPos = findNode(b, nodes);
            if(bPos != -1){
                nodes.remove(bPos);
            }
            //add b to "next arraylist" of A (whether retrieved or created)

        }

       //loop through nodes list
       //sum = 0, multiply (current set size + old sum) with next


        long combinations = 0;

       for (int i = 1; i < nodes.size(); i++){
           combinations = (sizeOfNodeList(nodes.get(i-1))+combinations)*sizeOfNodeList(nodes.get(i));
       }

        // Compute the final answer - the number of combinations

        System.out.println(combinations);

    }
    /**
    static int findNode(int searchVal, ArrayList<Node> nodes){
        for (int i = 0; i < nodes.size(); i++){
            if(nodes.get(i).value == searchVal){
                return i;
            }
        }
        return -1;
    }

    static int sizeOfNodeList(Node node){
        if (node.getNodeSize() == 0){
            return 1;
        } else {
            int sum = 0;
            for (int i = 0; i < node.nextNodes.size(); i++){
                sum += sizeOfNodeList(node.nextNodes.get(i));
            }
            return sum;
        }
    }
    **/
} //JFLDSJFKHDSJKFHDSJKHFDSJK this is the end of the class
/**
class Node{
    int value;
    ArrayList<Node> nextNodes;

    Node(int value){
        nextNodes = new ArrayList<Node>();
        this.value = value;
    }

    int getNodeSize(){
        return (int)nextNodes.size();
    }

    void addChild(Node next){
        nextNodes.add(next);
    }
}**/
