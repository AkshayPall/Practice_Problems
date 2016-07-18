import java.io.*;
import java.util.*;
import java.util.Random;

public class ThreeNArraySolver {

	public static void main (String args[]){
			Scanner in = new Scanner(System.in);

			int n = in.nextInt();	//size of arrays
			int k = in.nextInt();	//sum to be found
			int z = in.nextInt(); //range of integers, where 0 is median

			int[] firstAr = new int[n];
			int[] secondAr = new int[n];	//initializing the
			int[] thirdAr = new int[n];	//arrays

			for (int i = 0; i < n; i++){
				Random rand = new Random();
				for (int j = 1; j <= 3; j++){
					int rInt = rand.nextInt(z) - z/2;	//random int in range
																									//of -z/2 to +z/2
					switch (j) {
						case 1:
							firstAr[i] = rInt;
							break;
						case 2:
							secondAr[i] = rInt;
							break;
						default:
							thirdAr[i] = rInt;
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


			Quicksort qcksrt = new Quicksort();
			//TODO: sort firstAr and secondAR
			firstAr = Quicksort.sortRecur(firstAr, 0, n-1);
			secondAr = Quicksort.sortRecur(secondAr, 0, n-1);

			System.out.println("\nSORTED");
			printArray(firstAr);
			printArray(secondAr);

			//TODO: create sum 2d array

			//TODO: iterate through thirdAr while comparing
			//to values in the 

	}

	static void printArray(int ar[]){
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i]+" ");
		}
		System.out.println("");
	}

}