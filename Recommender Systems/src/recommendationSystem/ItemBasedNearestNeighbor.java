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

}// end class
