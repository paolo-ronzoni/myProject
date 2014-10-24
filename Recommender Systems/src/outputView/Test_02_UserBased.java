package outputView;

import recommendationSystem.*;
import fileIO.IOMethods;
import java.util.Arrays;

/* This class test the matrix Table 2.1. Ratings database for collaborative recommendation (pag. 14 from book "Recommender Systems An Introduction by Jannach & al.)
 */

public class Test_02_UserBased {


		static double[][] doubleMatrix = {{23.2, 11.5, 18.23}, 
			  {7.89, 56.1, 1.00}};
	static String path1 = "DataStore\\bookDataTab2dot1.txt";
	static String path2 = "DataStore\\ItemItemSimilarity.txt";
	static String splitExpression = "\\s+";
		
			
			
	public static void main(String[] args) {

		String[][] myMatrix = IOMethods.txtMatrix(path1, splitExpression);

		
//---input elements for the formula of userBasedSiamilarity------

// the rectangular matrix of user, items and ratings
int[][] secondMatrix = IOMethods.matrixConversion(myMatrix);

int columnOfUsers = 0; // the column, in the rectangular input matrix with the users

int firstUser = 1; // the first user to compute the similarity

 
double nearestValue;
for (int secondUser = 2; secondUser <= 5; secondUser++) 
{
	nearestValue = UserBasedNearestNeighbor.userNearestNeighborValue(secondMatrix, columnOfUsers, 1, secondUser);
		   System.out.printf("Similarity user 1 and %s: %6.2f\n", secondUser,nearestValue);
}
	 
	// nearestValue = UserBasedNearestNeighbor.userNearestNeighborValue(secondMatrix, 0, 2, 1);
	// 
//	     System.out.println("fatto! and nearest:" + nearestValue);
	     int userID = 57;
	     int itemID = 12;
	     int neighborNum = 10;
	     
//	     double[][] predictionMatrix;
//	     // double [][] workingMatrix = MatrixBuilder.userIDchoicesDouble(secondMatrix, 0, userID);
//	     int [][] theSolutionMatrix = MatrixBuilder.userIDchoices(secondMatrix, 0, userID);
//		 IOMethods.printMatrix(theSolutionMatrix, "%4s\t");
//		    int[] itemsUsed = MatrixBuilder.findAllUsers(theSolutionMatrix, 1);	
//		    Arrays.sort(itemsUsed);
//	    		 
//	     for (int i = 1; i < 6; i++) {
//	    	// print the matrix with user and item data
//			predictionMatrix = UserBasedNearestNeighbor
//					.TMPpredictionUserBasedValue(secondMatrix, 0, userID, 1,
//							itemsUsed[i], neighborNum);
//			System.out.println("The matrix num: " + i + " product: " + itemsUsed[i] );
//			IOMethods.printMatrix(predictionMatrix, "%4s\t"); } //end for
	    	 
//	    	 // print the prediction value.
//			double predictionValue = UserBasedNearestNeighbor.predictionUserBasedValue(secondMatrix, 0, i, 2, itemID, neighborNum);
//			System.out.println("User: " + i + "value: " + predictionValue);
	     
//			     double predictionValues; // = UserBasedNearestNeighbor.predictionUserBasedValue(secondMatrix, 0, 1, 2, 5, 2);
	//
	//// find the predictionUserBasedValue		     
//			     int[] elements = MatrixBuilder.findAllUsers(secondMatrix, 1);
//			     for (int i = 1; i < elements.length; i++) {
//			     predictionValues = UserBasedNearestNeighbor.predictionUserBasedValue(secondMatrix, 0, userID, 1, elements[i], neighborNum);
//			     System.out.println("user: " + i + " " + predictionValues);}
	//	
	     
	     
	     

	} // end main

} // end class Test_02_UserBased
