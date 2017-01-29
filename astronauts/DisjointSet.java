import java.util.*;
public class DisjointSet{

  private Map<Long, Node> map = new HashMap<>();
  //to easily find a node given the data

  class Node{
    int rank;
    long value;
    Node parent;
  }

  //make a set quickly
  public void makeSet(long value){
    Node node = new Node();
    node.rank = 0;
    node.value = value;
    node.parent = node;

    map.put(value, node);
  }

  public long findSetData (long data){
    return findSetOfNode(map.get(data)).value;
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

    void union (long first, long second){
    Node a = map.get(first);
    Node b = map.get(second);

    Node parentA = findSetOfNode(a);
    Node parentB = findSetOfNode(b);

    if(parentA.value == parentB.value){
      return;
    }

    if (parentA.rank >= parentB.rank){
      parentB.rank = 0;
      parentA.rank = (parentA.rank == parentB.rank) ?
                      parentA.rank + 1 : parentA.rank;
      parentB.parent = parentA;
    } else {
      parentA.rank = 0;
      parentB.rank++;
      parentA.parent = parentB;
    }
  }
/**
  public static void main (String args[]){
    DisjointSet ds = new DisjointSet();
    ds.makeSet(1);
    ds.makeSet(2);
    ds.makeSet(3);
    ds.makeSet(4);

    ds.union(1,3);
    ds.union(2,4);

    System.out.println(""+ds.findSetData(3));
    System.out.println(""+ds.findSetData(4));

    ds.union(1,4);
    System.out.println(""+ds.findSetData(3));

  }**/
}
