package outputView;

import recommendationSystem.*;
import fileIO.IOMethods;
import java.util.Arrays;


public class UserBasedTestResult {

	static double[][] doubleMatrix = {{23.2, 11.5, 18.23}, 
		  {7.89, 56.1, 1.00}};
static String path1 = "DataStore\\uPablo.txt";
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
	 nearestValue = UserBasedNearestNeighbor.userNearestNeighborValue(secondMatrix, 0, 401, k);
	 // if (Double.isNaN(nearestValue)) {
	 System.out.println("value(1," + k + "): " + nearestValue);
	 //}
 } //end for
 
 nearestValue = UserBasedNearestNeighbor.userNearestNeighborValue(secondMatrix, 0, 2, 1);
 
     System.out.println("fatto! and nearest:" + nearestValue);
     int userID = 57;
     int itemID = 12;
     int neighborNum = 10;
     
     double[][] predictionMatrix;
     // double [][] workingMatrix = MatrixBuilder.userIDchoicesDouble(secondMatrix, 0, userID);
     int [][] theSolutionMatrix = MatrixBuilder.userIDchoices(secondMatrix, 0, userID);
	 IOMethods.printMatrix(theSolutionMatrix, "%4s\t");
	    int[] itemsUsed = MatrixBuilder.findAllUsers(theSolutionMatrix, 1);	
	    Arrays.sort(itemsUsed);
    		 
     for (int i = 151; i <itemsUsed.length; i++) {
    	// print the matrix with user and item data
		predictionMatrix = UserBasedNearestNeighbor
				.TMPpredictionUserBasedValue(secondMatrix, 0, userID, 1,
						itemsUsed[i], neighborNum);
		System.out.println("The matrix num: " + i + " product: " + itemsUsed[i] );
		IOMethods.printMatrix(predictionMatrix, "%4s\t"); } //end for
    	 
    	 // print the prediction value.
//		double predictionValue = UserBasedNearestNeighbor.predictionUserBasedValue(secondMatrix, 0, i, 2, itemID, neighborNum);
//		System.out.println("User: " + i + "value: " + predictionValue);
     
//		     double predictionValues; // = UserBasedNearestNeighbor.predictionUserBasedValue(secondMatrix, 0, 1, 2, 5, 2);
//
//// find the predictionUserBasedValue		     
//		     int[] elements = MatrixBuilder.findAllUsers(secondMatrix, 1);
//		     for (int i = 1; i < elements.length; i++) {
//		     predictionValues = UserBasedNearestNeighbor.predictionUserBasedValue(secondMatrix, 0, userID, 1, elements[i], neighborNum);
//		     System.out.println("user: " + i + " " + predictionValues);}
	
     
     
     

	} // end main

} // end class
