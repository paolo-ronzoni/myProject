package outputView;

import inProcessing.FormulaBuilding;
import recommendationSystem.ItemBasedNearestNeighbor;
import recommendationSystem.MatrixBuilder;
import recommendationSystem.UserBasedNearestNeighbor;
import fileIO.IOMethods;

public class ItemBasedTestResult {

	static double[][] doubleMatrix = {{23.2, 11.5, 18.23}, 
		  {7.89, 56.1, 1.00}};
static String path1 = "DataStore\\u.txt";
static String path2 = "DataStore\\provaFinale.txt";
static String splitExpression = "\\s+";
	
		
		
public static void main(String[] args) {

	String[][] myMatrix = IOMethods.txtMatrix(path1, splitExpression);
	// IOMethods.printMatrix(myMatrix, "%4s\t");
	int[][] secondMatrix = IOMethods.matrixConversion(myMatrix);
	
	double [][] solutionMatrix = MatrixBuilder.doubleItemRatingMatrix(secondMatrix, 0, 4, 23);
IOMethods.printMatrix(solutionMatrix, "%4s\t");

		double  itemBasedValue = ItemBasedNearestNeighbor.itemBasedNearestNeighborValue(secondMatrix, 0, 1, 18);
		System.out.println("ItemBasedValue: " + itemBasedValue);


	} // end main

}// end class
