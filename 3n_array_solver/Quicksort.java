import java.io.*;
import java.util.*;

public class Quicksort {

	public static void main (String args[]) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();	//size of array
		int ar[] = new int[n];	//array

		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}

		//recursively partition and sort array
		ar = sortRecur(ar, 0, ar.length-1);

		printArray(ar, ar.length);

	}

	public static int[] sortRecur (int[] ar, int startIndex, 
	                               int endIndex){
		int subArLength = endIndex + 1 - startIndex;
		if (subArLength > 1){ //if more than one int
			int p = ar[startIndex];		//the pivot point

			int[] left = new int[subArLength-1];	//left array
			int lIndex = 0;			//left index

			int[] equal = new int[subArLength];	//equal to p array
			int eIndex = 1;			//equal index
			equal[0] = p;
		
			int[] right = new int[subArLength-1];	//right array
			int rIndex = 0;			//right index

			for (int j = startIndex+1; j <= endIndex ; j++) {
				if (ar[j] > p) {
					right[rIndex] = ar[j];
					rIndex++;
				} else if (ar[j] == p) {
					equal[eIndex] = ar[j];
					eIndex++;
				}
				else {
					left[lIndex] = ar[j];
					lIndex++;
				}
			}

			//save changes to ar
			int k = startIndex;
			int progress = 0;
			while (k <= endIndex){
				while(progress < lIndex){
					ar[k] = left[progress];
					k++;
					progress++;
				}
				progress = 0;
				while(progress < eIndex){
					ar[k] = equal[progress];
					k++;
					progress++;
				}
				progress = 0;
				while(progress < rIndex){
					ar[k] = right[progress];
					k++;
					progress++;
				}
			}

			//printArray(ar, ar.length);

			//call on left
			ar = sortRecur(ar, startIndex, startIndex + lIndex-1);

			//call on right
			ar = sortRecur(ar, endIndex - rIndex + 1,
			               endIndex);

		}

		return ar;
	}

	static void printArray(int ar[], int arIndex){
		System.out.println("");
		for (int i = 0; i < arIndex; i++) {
			System.out.print(ar[i]+" ");
		}
	}
}
