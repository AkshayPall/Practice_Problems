public Starting{

  final static int BLOCKED = 1;
  final static int CLEAR = 0;

  private static void main (String args[]){
      //2d array representing map to traverse
      //1 = the node is blocked (can not pass through)
      //0 = node is empty; you can include it in your path
      int map[][] = {{0,0,0,0},
                     {0,1,0,0},
                     {0,0,1,0},
                     {0,0,0,0},
                     {0,0,0,0};
  }
}

//d = min(dx, dy) * 14 + abs(dx - dy) * 10
//distance formula of the correct node from the target or starting node
//(can use for both). dx and dy = delta x and delta y

/** TODO:
 *  - make "node" class with x, y, hcost, gcost, fcost, and parent Node fields
 *  - create node "equality" method (check if the x and y values are equal)
 *  - create fcost calculator method (saves h and gcosts within it)
 */
