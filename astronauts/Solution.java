import java.util.*;
import java.io.*;

public class Solution {
   public static void main(String[] args) throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bfr.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int I = Integer.parseInt(temp[1]);

        DisjointSet ds = new DisjointSet();
        for(int i = 0; i < I; i++){
            temp = bfr.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            if(ds.nodesMap.get(a) == null){
              ds.makeSet(a);
            }
            if (ds.nodesMap.get(b) == null){
              ds.makeSet(b);
            }

            ds.union(a,b);
            //add b to "next arraylist" of A (whether retrieved or created)

        }

        long combinations = 0;
        if (ds.setList.size() > 1){
            long sumOfSizes = ds.setList.get(ds.setList.size()-1).sizeOfSet;
            for (int i = ds.setList.size() - 2; i > -1; i--){
              combinations += (sumOfSizes)*ds.setList.get(i).sizeOfSet;
              sumOfSizes += ds.setList.get(i).sizeOfSet;
            }
        }

        // Compute the final answer - the number of combinations

        System.out.println(combinations);

    }
}

class DisjointSet{

  public Map<Long, Node> nodesMap = new HashMap<>();
  public ArrayList<Node> setList = new ArrayList<>();
  //to easily find a node given the data

  class Node{
    int rank;
    long value;
    Node parent;
    long sizeOfSet;
  }

  //make a set quickly
  public void makeSet(long value){
    Node node = new Node();
    node.rank = 0;
    node.value = value;
    node.parent = node;
    setList.add(node);
    node.sizeOfSet = 1;

    nodesMap.put(value, node);
  }

  public long findSetData (long data){
    return findSetOfNode(nodesMap.get(data)).value;
  }

  public long findSetSize(long data){
    //
    return 0;
  }

  /** INCLUDES PATH COMPRESISON OPTIMIZATION **/
  Node findSetOfNode(Node node){
    Node parent = node.parent;
    if(parent == node){
      return parent;
    }
    node.parent = findSetOfNode(node.parent);
    return node.parent;
  }

  public void union (long first, long second){
    Node a = nodesMap.get(first);
    Node b = nodesMap.get(second);

    Node parentA = findSetOfNode(a);
    Node parentB = findSetOfNode(b);

    if(parentA.value == parentB.value){
      return;
    }

    if (parentA.rank >= parentB.rank){
      parentB.rank = 0;
      parentA.rank = (parentA.rank == parentB.rank) ?
                      parentA.rank + 1 : parentA.rank;
      parentA.sizeOfSet = parentA.sizeOfSet + parentB.sizeOfSet;
      setList.remove(parentB);
      parentB.parent = parentA;
    } else {
      parentA.rank = 0;
      parentB.rank++;
      parentB.sizeOfSet = parentB.sizeOfSet + parentA.sizeOfSet;
      setList.remove(parentA);
      parentA.parent = parentB;
    }
  }
}
