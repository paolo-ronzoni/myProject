package recommendationSystem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import fileIO.IOMethods;

public class ItemBasedNearestNeighbor {
	
	
	/** 
	 * @param inputMatrix an input matrix of type int
	 * @param columnNumber the position of the column where to search
	 * @param firstElementSearched the first element searched
	 * @param secondElementSearched the second element searched
	 * @return 
	 * @author Paolo Ronzoni
	 */
	public static double adjustedCosineSimilarity(int[][] inputMatrix, int columnNumber, int firstElementSearched, int secondElementSearched) {		
		
		// create a matrix of three column: items, user1scores, user2scores
		double[][] intermediateMatrix = MatrixBuilder.doubleItemRatingMatrix(inputMatrix, columnNumber,firstElementSearched, secondElementSearched);
		
		int numRows = intermediateMatrix.length;
		
		int item1columnScores = 1;
		int item2columnScores = 2;
		int averagecolumnScores = 3;
		
		double numerator = 0;
		double denominator1 = 0;
		double denominator2 = 0;

		
		
		for (int row = 0; row < numRows  ; row++)
		{
		numerator += ((intermediateMatrix[row][item1columnScores] - intermediateMatrix[row][averagecolumnScores]) * (intermediateMatrix[row][item2columnScores] - intermediateMatrix[row][averagecolumnScores]));
		
		denominator1 += Math.pow((intermediateMatrix[row][item1columnScores] - intermediateMatrix[row][averagecolumnScores]),2);
		denominator2 += Math.pow((intermediateMatrix[row][item2columnScores] - intermediateMatrix[row][averagecolumnScores]),2);
			    	
		} // end for loop
		
		
		return (numerator / (Math.sqrt(denominator1 * denominator2)));
	 } // end method adjustedCosineMeasure
	
	/** 
	 * @param inputMatrix an input matrix of type int
	 * @param columnNumber the position of the column where to search
	 * @param firstElementSearched the first user searched
	 * @param secondElementSearched the second user searched
	 * @return 
	 * @author Paolo Ronzoni
	 */
	public static double cosineSimilarity(int[][] inputMatrix, int columnNumber, int firstElementSearched, int secondElementSearched) {		
		
		// create a matrix of three column: items, user1scores, user2scores
		double[][] intermediateMatrix = MatrixBuilder.simpleDoubleItemRatingMatrix(inputMatrix, columnNumber,firstElementSearched, secondElementSearched);
		
		int numRows = intermediateMatrix.length;
		
		int item1columnScores = 1;
		int item2columnScores = 2;

		
		double numerator = 0;
		double denominator1 = 0;
		double denominator2 = 0;

		
		
		for (int row = 0; row < numRows  ; row++)
		{
		numerator += (intermediateMatrix[row][item1columnScores]  * intermediateMatrix[row][item2columnScores]);
		
		denominator1 += Math.pow(intermediateMatrix[row][item1columnScores],2);
		denominator2 += Math.pow(intermediateMatrix[row][item2columnScores],2);
			    	
		} // end for loop
		
		
		return (numerator / (Math.sqrt(denominator1 * denominator2)));
	 } // end method adjustedCosineMeasure
	
	
	
	/** 
	 * @param inputMatrix an input matrix of type int
	 * @param usercolumnNumber the position of the column where to search the user
	 * @param userSearched the user that must be searched
	 * @param itemcolumnNumber the position of the column where to search the item
	 * @param itemSearched the item searched
	 * @return double the prediction of the rating for the item searched for the specific user
	 * @author Paolo Ronzoni
	 */
	public static double predictionItemBasedValue(int[][] inputMatrix, int userColumnNumber, int userSearched, int itemcolumnNumber, int itemSearched) {		
	
		// find the users matrtix of three columns userID, ItemID, rating
		int[][] intermediateMatrix =  MatrixBuilder.userIDchoices(inputMatrix, userColumnNumber,userSearched);
		
		int user1columnScores = 2;
		int numRows = intermediateMatrix.length;
		double numerator = 0;
		double denominator = 0;
		
		for (int row = 0; row < numRows  ; row++)
		{
	 
		numerator += (adjustedCosineSimilarity( intermediateMatrix, userColumnNumber, itemSearched, intermediateMatrix[row][user1columnScores])  * intermediateMatrix[row][user1columnScores] );
		
		denominator += adjustedCosineSimilarity( intermediateMatrix, userColumnNumber, itemSearched, intermediateMatrix[row][user1columnScores]);
		
			    	
		} // end for loop
		
		
		return numerator / denominator;
	 } // end method TMPpredictionUserBasedValue

}// end class
