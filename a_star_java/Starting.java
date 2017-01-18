public class Starting{

  final static int BLOCKED = 1;
  final static int CLEAR = 0;

  private static void main (String args[]){
      //2d array representing map to traverse
      //1 = the node is blocked (can not pass through)
      //0 = node is empty; you can include it in your path


      /**

        Map visualization

        - - - - - -
        - - - X - -
        - - X X X -
        - - X - - -
        - - - - - -
        - - - - - -

        **/
      UnitNode map[][] = new UnitNode[6][6];
      for (int i = 0; i < 6; i++){
        for (int j = 0; j < 6; j++){
          /** Check if the current position is one that should be blocked
            and if so use the appropriate constructor.
            **/
          map[i][j] = (3 == i && 1 == j)
                      || (3 == i && 1 == j)
                      || (3 == i && 2 == j)
                      || (2 == i && 2 == j)
                      || (4 == i && 2 == j)
                      || (2 == i && 3 == j)
                      ? new UnitNode(i,j,false) : new UnitNode(i,j);
        }
      }
  }
}

/** TODO:
    
 */
