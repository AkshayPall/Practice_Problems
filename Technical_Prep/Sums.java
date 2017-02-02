import java.io.*;
import java.util.*;

public class Sums{
  public static void main (String args[]){
    //take inputs, call 2 sum and 3sum
    int[] input = {0, -5, 5, 3, 9, -12};
    int desired = 14;
    int[] twoSumNums = twoSum(desired, input);
    System.out.println(twoSumNums[0]+" "+twoSumNums[1]);
    List<List<Integer>> threeSumNums = threeSum(input);
    for(List<Integer> list : threeSumNums){
      System.out.println(list.get(0)+" "+list.get(1)+" "+list.get(2));
    }
  }

  public static int[] twoSum (int desired, int[] input){
    //return indices! easily changabel to value
    //sort
    int[] toReturn = new int[2];
    HashMap<Integer, Integer> nums = new HashMap<>();
    for(int i = 0; i < input.length; i++){
      if(nums.containsKey(desired - input[i])){
        //has the two value necessary
        toReturn[1] = i;
        toReturn[0] = nums.get(desired-input[i]);
        return toReturn;
      }
      //else do this
      nums.put(input[i], i);
    }
    toReturn[0] = -1;
    toReturn[1] = -1;
    return toReturn;
  }

  public static List<List<Integer>> threeSum (int[] input){
    Arrays.sort(input);
    List<List<Integer>> toRet = new ArrayList<>(); //TODO: TRY WITH ARRAYLIST AFTER
    for(int i = 0; i < input.length-2; i++){
      if(i == 0 || (i > 0 && input[i] != input[i-1])){ //don't really need to check if i>0 so i didnt put it in
        int low = i+1;
        int high = input.length-1;
        int sum = -input[i]; //get a sum of this so that get 3 nums = 0!
        while(low < high){
          if(input[low] + input[high] == sum){
            toRet.add(Arrays.asList(input[high], input[low], input[i]));
            while(low < high && input[low] == input[low+1]) low++;
            while(low < high && input[high] == input[high-1]) high--;
            high--;
            low++;
          } else if (input[low] + input[high] < sum){
            while(low < high && input[low] == input[low+1]) low++;
            low++; //higher sum
          } else {
            //want lower sum
            while(low < high && input[high] == input[high-1]) high--;
            high--;
          }
        }
      }
    }
    return toRet;
  }
}
