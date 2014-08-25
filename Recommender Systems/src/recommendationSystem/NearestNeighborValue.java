package recommendationSystem;

public class NearestNeighborValue {

	
	/** 
	 * @param inputMatrix an input matrix of type int
	 * @param columnNumber position of the column where to search
	 * @param firstelementSearched the first user searched
	 * @param secondelementSearched the second user searched
	 * @return a three column matrix with the common choices of the two users
	 * @author Paolo Ronzoni
	 */
	public static double nearestNeigborValue(int[][] inputMatrix, int columnNumber, int firstElementSearched, int secondElementSearched) {		
		
		// create a matrix of three column: items, user1scores, user2scores
		int[][] intermediateMatrix = MatrixBuilder.matchIDchoices(inputMatrix, columnNumber,firstElementSearched, secondElementSearched);
		
		int user1columnScores = 1;
		int user2columnScores = 2;
		int numRows = inputMatrix.length;
		double numerator = 0;
		double denominator1 = 0;
		double denominator2 = 0;
		double finalValue = 0;
		
		// calculates the averages of the columns' users scores 
		double User1Average = StatAndMathTools.matrixColumnAverage(inputMatrix, user1columnScores);
		double User2Average = StatAndMathTools.matrixColumnAverage(inputMatrix, user2columnScores);
		
		
		for (int row = 0; row < numRows  ; row++)
		{
		numerator += (intermediateMatrix[row][user1columnScores] - User1Average) * (intermediateMatrix[row][user2columnScores] - User2Average);
		
		denominator1 = Math.pow((intermediateMatrix[row][user1columnScores] - User1Average),2);
		denominator2 = Math.pow((intermediateMatrix[row][user2columnScores] - User2Average),2);
			    	
		} // end outer for 	
		
		
		return numerator / (Math.sqrt(denominator1 * denominator2));
	 } // end method matchIdChoices
}
