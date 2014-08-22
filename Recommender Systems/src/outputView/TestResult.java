package outputView;

import recommendationSystem.*;
import fileIO.IOMethods;


public class TestResult {

	static double[][] doubleMatrix = {{23.2, 11.5, 18.23}, 
		  {7.89, 56.1, 1.00}};
static String path1 = "DataStore\\u.txt";
static String path2 = "DataStore\\doubleNumbers.txt";
static String splitExpression = "\\s+";
	
		
		
public static void main(String[] args) {

	String[][] myMatrix = IOMethods.txtMatrix(path1, splitExpression);
	// IOMethods.printMatrix(myMatrix, "%4s\t");
	int[][] secondMatrix = IOMethods.matrixConversion(myMatrix);
	// int[] matrix1 = IOMethods.columnExtractor(secondMatrix, 0);
	// IOMethods.printMatrix(secondMatrix, "%4s\t");


//	int elementFounded = MatrixBuilder.numberOfElement(secondMatrix, 0, 186);
//	System.out.println("element founded: " + elementFounded);
//	System.out.println("matrix length: " + secondMatrix.length);
     for (int i = 1; i < 30; i++) {
    	int [][] finalMatrix = MatrixBuilder.userIDchoices(secondMatrix, 0, i);
     }
	
// IOMethods.printMatrix(finalMatrix, "%4s\t");
     System.out.println("fatto!");
	} // end main

} // end class
