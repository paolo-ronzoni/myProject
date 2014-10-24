package outputView;

import recommendationSystem.*;
import fileIO.IOMethods;
import java.util.Arrays;

/* This class test the matrix Table 2.1. Ratings database for collaborative recommendation (pag. 14 from book "Recommender Systems An Introduction by Jannach & al.)
 */

public class Test_01_UserBased {

	static String path1 = "DataStore\\bookDataTab2dot1.txt";
	static String splitExpression = "\\s+";
		
			
			
	public static void main(String[] args) {

		String[][] myMatrix = IOMethods.txtMatrix(path1, splitExpression);
		System.out.printf("Print the matrix of table Table 2.1  pag. 14 from book: \n \"Recommender Systems An Introduction by Jannach & al.\" and the number of row and columns\nThe first column rapresent the Users: Alice =\"1\", User1 =\"2\", ... User4 =\"5\"\nThe secon column rapresent the Item: Item1 = \"1\", ... Item5 = \"5\"\nThe third column rapresent the ranking from 1 to 5\n");
		// print the String matrix
		IOMethods.printMatrix(myMatrix, "%4s\t");
		//trasform the String matrix in a matrix of type int
		int[][] secondMatrix = IOMethods.matrixConversion(myMatrix);
		 int[] matrix1 = IOMethods.columnExtractor(secondMatrix, 0);
		 IOMethods.printMatrix(matrix1, "%4s\t");




	} // end main

} // end class Test_01_UserBased
