package recommendationSystem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import fileIO.IOMethods;

public class ItemBasedNearestNeighbor {
	
	
	/** 
	 * @param inputMatrix an input matrix of type int
	 * @param columnNumber the position of the column where to search
	 * @param firstElementSearched the first user searched
	 * @param secondElementSearched the second user searched
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
	 * @param firstElementSearched the  user searched
	 * @param itemcolumnNumber the position of the column where to search the item
	 * @param itemSearched the item searched
	 * @param numOfNearestNeighbor the number of 
	 * @return double the prediction of the rating for the item searched for the specific user
	 * @author Paolo Ronzoni
	 */
	public static double[][] predictionItemBasedValue(int[][] inputMatrix, int userColumnNumber, int userSearched, int itemcolumnNumber, int itemSearched, int numOfNearestNeighbor) {		
		
		// find all users, without duplication, in the inputMatrix
		int[] usersVector = MatrixBuilder.findAllUsers(inputMatrix, userColumnNumber);
		
		// swap the userSearched position at the beginning of the usersVector
		for ( int i = 0; i < usersVector.length; i++) {
			if ( usersVector[i] == userSearched) {
				int tmp = usersVector[0];
				usersVector[0] = userSearched;
				usersVector[i] = tmp;
				break;
			}
		} // end for s
		
		// creates a matrix of three column: userSearched, allOtherUsers, userNearestNeighborValue
		double[][] intermediateMatrix = new double[usersVector.length -1][3];
		for (int row = 0; row < usersVector.length -1 ; row++) {
			intermediateMatrix[row][0] = userSearched;
			intermediateMatrix[row][1] = usersVector[row + 1];
			intermediateMatrix[row][2] = UserBasedNearestNeighbor.userNearestNeighborValue( inputMatrix, userColumnNumber,  userSearched, usersVector[row + 1]);
		}
		
		// orders the intermediateMatrix respect to userNearestNeighborValue
		int lastMatrixColumn = 5;
		double[][] finalMatrix = StatAndMathTools.sortMultidimensionArray(intermediateMatrix, 2);
		double[][] lastMatrix = new double[numOfNearestNeighbor][lastMatrixColumn];
		int lastRow = finalMatrix.length - 1;
		double[][] forMatrix;
		for ( int i = 0; i < numOfNearestNeighbor; i++) {	 
			forMatrix = MatrixBuilder.userIDchoicesDouble(inputMatrix, userColumnNumber,(int) finalMatrix[lastRow][1]);
			 while( Double.isNaN(finalMatrix[lastRow][2]) || 
					 !MatrixBuilder.isThereItem(forMatrix, 1, itemSearched)) {
				lastRow -= 1;
				forMatrix = MatrixBuilder.userIDchoicesDouble(inputMatrix, userColumnNumber,(int) finalMatrix[lastRow][1]);
			
			} // end while
			 
			// forMatrix is a  matrix of three column userID, itemID, rating
			 

			 // || !MatrixBuilder.isThereItem(forMatrix, 1, 5)
		     // if () {
			 lastMatrix[i][0] = finalMatrix[lastRow][0]; // the user searched
			 lastMatrix[i][1] = finalMatrix[lastRow][1]; // an other users
			 lastMatrix[i][4] = finalMatrix[lastRow][2];
			 
			 lastMatrix[i][2] = MatrixBuilder.getItem(forMatrix, 1, itemSearched, 2);
			 lastMatrix[i][3] = StatAndMathTools.matrixColumnAverage(forMatrix,2 );
			 lastRow--;
//		     } else {
//				lastRow--;
//			  }
		} // end for
		
		
		
		int user1columnScores = 1;
		int user2columnScores = 2;
		int numRows = intermediateMatrix.length;
		double numerator = 0;
		double denominator1 = 0;
		double denominator2 = 0;
		
		// calculates the averages of the columns' users scores 
		double user1Average = StatAndMathTools.matrixColumnAverage(intermediateMatrix, user1columnScores);
		double user2Average = StatAndMathTools.matrixColumnAverage(intermediateMatrix, user2columnScores);
		
		
		for (int row = 0; row < numRows  ; row++)
		{
		numerator += ((intermediateMatrix[row][user1columnScores] - user1Average) * (intermediateMatrix[row][user2columnScores] - user2Average));
		
		denominator1 += Math.pow((intermediateMatrix[row][user1columnScores] - user1Average),2);
		denominator2 += Math.pow((intermediateMatrix[row][user2columnScores] - user2Average),2);
			    	
		} // end for loop
		
		
		return lastMatrix;
	 } // end method TMPpredictionUserBasedValue

}// end class
