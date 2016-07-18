import java.io.*;
import java.util.*;

public class 3nArraySolver {

	public static void main (String args[]){
			Scanner in = new Scanner(System.in);

			int n = in.nextInt();	//size of arrays
			int k = in.nextInt();	//sum to be found
			int z = in.nextInt(); //range of integers, where 0 is median

			static int[] firstAr = new int[n];
			static int[] secondAr = new int[n];	//initializing the
			static int[] thirdAr = new int[n];	//arrays

			for (int i = 0; i < n; i++){
				for (int k = 1; k <= 3; k++){
					int rand = (int)Math.random()*z - z/2;	//random int in range
																									//of -z/2 to +z/2
					switch k{
						case 1:
							firstAr[i] = rand;
							break;
						case 2:
							secondAr[i] = rand;
							break;
						default:
							thirdAr[i] = rand;
							break;
					}
				}
			}

			//print the arrays prior to solving
			System.out.println("Array 1");
			printArray(firstAr);

			System.out.println("Array 2");
			printArray(secondAr);

			System.out.println("Array 3");
			printArray(thirdAr);

			
	}

	static void printArray(int ar[], int arIndex){
		System.out.println("");
		for (int i = 0; i < arIndex; i++) {
			System.out.print(ar[i]+" ");
		}
	}

}