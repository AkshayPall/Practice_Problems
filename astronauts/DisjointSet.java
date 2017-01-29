public DisjointSet{

  private Map<Long, Node> map = new HashMap<>();
  //to easily find a node given the data

  class Node{
    int rank;
    long value;
    Node parent;
  }

  //make a set quickly
  DisjointSet makeSet(long value){
    Node temp = new Node();
    temp.rank = 0;
    temp.value = value;
    temp.parent = temp;

    map.put(temp);
  }
}
