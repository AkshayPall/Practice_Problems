public class UnitNode {

  /**
    Static integer representing an uncalculated cost balue
    **/
  public static final int UNCALCULATED_COST = -1;

  /**
    Costs, together calculated from updateCostFields() and individually
    calculated from costFromNode method
    **/
  int hCost = -1; //Heuristic cost (from end)
  int gCost = -1; //cost from start
  int fCost = -1; //Cost

  /**
    X and Y position of node, representing index of primary and secondary
    arrays in the UnitNode 2D array (representing the map)
    **/
  int xPos = -1;
  int yPos = -1;

  /**
    To determine if this UnitNode is blocked (not accessible) and thus not
    permitted ot be part of the path, or if it is.

    By default, it is assumed that each node is accessible.
    **/
  boolean isAccessible = true;

  /**
    To keep track of best path!
    **/
  UnitNode parent;

  public UnitNode(int x, int y){
    xPos = x;
    yPos = y;
  }
  public UnitNode(int x, int y, boolean isAccessible){
    xPos = x;
    yPos = y;
    this.isAccessible = isAccessible;
  }

  public void updateCostFields(UnitNode start, UnitNode destination){
    gCost = costFromNode(start);
    hCost = costFromNode(destination);

    fCost = gCost + hCost;
  }

  private int costFromNode(UnitNode toCompareTo){
    /**
      cost is = min(dx, dy) * 14 + abs(dx - dy) * 10
      (This uses a score of 10 for one block length away,
      making diagonal distances of sqrt(2)*10 ~= 14)
      **/

    int dx = abs(this.xPos - toCompareTo.xPos);
    int dy = abs(this.yPos - toCompareTo.yPos);

    return min(dx,dy)*14 + abs(dx-dy)*10;
  }

  public static boolean areNodesEqual (UnitNode start, UnitNode end){
    return (start.xPos == end.xPos) && (start.yPos == end.yPos);
  }
}
