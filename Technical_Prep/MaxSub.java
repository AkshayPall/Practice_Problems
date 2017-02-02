import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxSub {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(bfr.readLine());
        for (int i = 0; i < cases; i++){
            int size = Integer.parseInt(bfr.readLine());
            String[] nums = bfr.readLine().split(" ");
            //for noncontig
            int max = 0;
            int maxValue = Integer.MIN_VALUE;
            //for contiguous
            int cMax = 0;
            int cSum = 0;

            //1) find max, start index and currMax here
            //2) compare whether adding the next index or removing the last would be beneficial

            for (int k = 0; k < size; k++){
                int temp = Integer.parseInt(nums[k]);

                /** the following is for non contig **/
                if(temp > maxValue){
                    max = k;
                    maxValue = temp;
                }
                /*****/

                cSum = Math.max(temp, temp+cSum);
                cMax = Math.max(cMax, cSum);
            }
            //for non-contig
            int ncMax = Integer.parseInt(nums[max]);
            for (int j = max+size-1; j > max; j--){
                int curr = Integer.parseInt(nums[j%size]);
                if((ncMax+curr) > ncMax){
                    ncMax += curr;
                }
            }
            if(maxValue < 0){
              cMax = maxValue;
            }
            System.out.println(cMax+" "+ncMax);
            //determine max contiguous and max non-contigious
        }

    }
}
