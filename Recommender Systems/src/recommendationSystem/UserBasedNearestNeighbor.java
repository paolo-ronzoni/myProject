package recommendationSystem;

public class UserBasedNearestNeighbor {

	
	/** 
	 * @param inputMatrix an input matrix of type int
	 * @param columnNumber the position of the column where to search the user
	 * @param firstElementSearched the first user searched
	 * @param secondElementSearched the second user searched
	 * @return 
	 * @author Paolo Ronzoni
	 */
	public static double userNearestNeighborValue(int[][] inputMatrix, int columnNumber, int firstElementSearched, int secondElementSearched) {		
		
		// create a matrix of three column: items, user1scores, user2scores
		int[][] intermediateMatrix = MatrixBuilder.matchIDchoices(inputMatrix, columnNumber,firstElementSearched, secondElementSearched);
		
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
		
		
		return (numerator / (Math.sqrt(denominator1 * denominator2)));
	 } // end method userNearestNeighborValue
	
	
	/** 
	 * @param inputMatrix an input matrix of type int
	 * @param usercolumnNumber the position of the column where to search the user
	 * @param firstElementSearched the  user searched
	 * @param itemcolumnNumber the position of the column where to search the item
	 * @param itemSearched the item searched
	 * @return double the prediction of the rating for the item searched for the specific user
	 * @author Paolo Ronzoni
	 */
	public static double predictionUserBasedValue(int[][] inputMatrix, int userColumnNumber, int firstElementSearched, int secondElementSearched) {		
		
		// create a matrix of three column: items, user1scores, user2scores
		int[][] intermediateMatrix = MatrixBuilder.matchIDchoices(inputMatrix, columnNumber,firstElementSearched, secondElementSearched);
		
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
		
		
		return (numerator / (Math.sqrt(denominator1 * denominator2)));
	 } // end method predictionUserBasedValue
	
} // end class
