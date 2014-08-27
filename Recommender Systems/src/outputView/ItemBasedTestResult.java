package outputView;

import recommendationSystem.ItemBasedNearestNeighbor;
import recommendationSystem.MatrixBuilder;
import recommendationSystem.UserBasedNearestNeighbor;
import fileIO.IOMethods;

public class ItemBasedTestResult {

	static double[][] doubleMatrix = {{23.2, 11.5, 18.23}, 
		  {7.89, 56.1, 1.00}};
static String path1 = "DataStore\\u1.txt";
static String path2 = "DataStore\\provaFinale.txt";
static String splitExpression = "\\s+";
	
		
		
public static void main(String[] args) {

	String[][] myMatrix = IOMethods.txtMatrix(path1, splitExpression);
	// IOMethods.printMatrix(myMatrix, "%4s\t");
	int[][] secondMatrix = IOMethods.matrixConversion(myMatrix);
	
	int [][] solutionMatrix = MatrixBuilder.singleUserIDchoices(secondMatrix, 0, 1);
IOMethods.printMatrix(solutionMatrix, "%4s\t");

int[] users = ItemBasedNearestNeighbor.findAllUsers(secondMatrix, 0);
for (int element: users) {
	System.out.println(element + " ");
}


	} // end main

}// end class
