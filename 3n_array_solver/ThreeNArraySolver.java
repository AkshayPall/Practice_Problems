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


			//Sort firstAr and secondAR
			Quicksort qcksrt = new Quicksort();
			firstAr = Quicksort.sortRecur(firstAr, 0, n-1);
			secondAr = Quicksort.sortRecur(secondAr, 0, n-1);

			System.out.println("\nSORTED");
			printArray(firstAr);
			printArray(secondAr);

			//Create amd setup sum 2d array
			int[][] sMatrix = new int [n+1][n+1]; //2d sum array
			//setup
			for (int p = 0; p < n+1; p++){
				//let p represent rows
				for (int l = 0; l < n+1; l++){
					//let l represent columns

					//setup arrays
					if (p==0 && l>0){
						sMatrix[l][p] = firstAr[l-1];
					} else if (l==0 && p>0){
						sMatrix[l][p] = secondAr[n-p];
					} else if (l!=0 && p!=0){
						//sum the values
						sMatrix[l][p] = firstAr[l-1] + secondAr[n-p];
					} else {
						sMatrix[l][p] = 0; //for the origin location
					}

					System.out.print("\t"+sMatrix[l][p]);
				}
				System.out.println("");
			}

			//iterate through thirdAr while comparing
			//to values in the 2d array/matrix
			for(int f = 0; f < n; f++){
				//let f be used to iterate through thirdAr
				int sumNeeded = k-thirdAr[f];
				int L = 1;
				int P = 1;
				boolean success = false;

				while(!success && L < n+1 && P < n+1){
					if (sumNeeded == sMatrix[L][P]){
						success = true;
						System.out.println("\n\nSUCCESS, sum of "+k+" exists from "
						                   +firstAr[L-1]+", "+secondAr[n-P]+", "
						                   +thirdAr[f]);
					} else if (sumNeeded < sMatrix[L][P]){
						//too high, need to move down
						P++;
					} else {
						//too low, move right
						L++;
					}
				}
			}
	}

	static void printArray(int ar[]){
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i]+" ");
		}
		System.out.println("");
	}

}