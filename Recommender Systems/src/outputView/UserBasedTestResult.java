package outputView;

import recommendationSystem.*;
import fileIO.IOMethods;


public class UserBasedTestResult {

	static double[][] doubleMatrix = {{23.2, 11.5, 18.23}, 
		  {7.89, 56.1, 1.00}};
static String path1 = "DataStore\\u.txt";
static String path2 = "DataStore\\bookDataTab2dot1.txt";
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
	int [][] solutionMatrix = MatrixBuilder.matchIDchoices(secondMatrix, 0, 1, 3);
 IOMethods.printMatrix(solutionMatrix, "%4s\t");
 double nearestValue = 0;
 for (int k = 1; k <= 5; k++ ) 
 {
	 nearestValue = UserBasedNearestNeighbor.userNearestNeighborValue(secondMatrix, 0, 1, k);
	 // if (Double.isNaN(nearestValue)) {
	 System.out.println("value(1," + k + "): " + nearestValue);
	 //}
 } //end for
 
 nearestValue = UserBasedNearestNeighbor.userNearestNeighborValue(secondMatrix, 0, 2, 1);
 
     System.out.println("fatto! and nearest:" + nearestValue);
     int userID = 56;
     int itemID = 12;
     int neighborNum = 4;
     
     double[][] predictionMatrix;
     
     for (int i = 1; i <= 943; i++) {
    	// print the matrix with user and item data
//		predictionMatrix = UserBasedNearestNeighbor
//				.TMPpredictionUserBasedValue(secondMatrix, 0, i, 1,
//						itemID, neighborNum);
//		IOMethods.printMatrix(predictionMatrix, "%4s\t"); 
		double predictionValue = UserBasedNearestNeighbor.predictionUserBasedValue(secondMatrix, 0, i, 2, itemID, neighborNum);
		System.out.println("User: " + i + "value: " + predictionValue);
     
		//     double predictionMatrixBis; // = UserBasedNearestNeighbor.predictionUserBasedValue(secondMatrix, 0, 1, 2, 5, 2);
		//     for (int i = 230; i <= 232; i++) {
		//     predictionMatrixBis = UserBasedNearestNeighbor.predictionUserBasedValue(secondMatrix, 0, userID, 2, i, neighborNum);
		//     System.out.println(predictionMatrixBis);}
	}
     
     
     

	} // end main

} // end class
