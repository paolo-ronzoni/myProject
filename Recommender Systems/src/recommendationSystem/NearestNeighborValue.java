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
	public static int[][] nearestNeigborValue(int[][] inputMatrix, int columnNumber, int firstElementSearched, int secondElementSearched) {		
		
		// create a matrix of three column: items, user1scores, user2scores
		int[][] intermediateMatrix = MatrixBuilder.matchIDchoices(inputMatrix, columnNumber,firstElementSearched, secondElementSearched);
		
		int user1columnScores = 1;
		int user2columnScores = 2;
		
		// calculates the averages of the columns' users scores 
		double firstUserAverage = StatAndMathTools.matrixColumnAverage(inputMatrix, user1columnScores);
		double secondUserAverage = StatAndMathTools.matrixColumnAverage(inputMatrix, user2columnScores);
		
		
		int[][] outputMatrix = new int[(int)Math.min(firstUserRows, secondUserRows)][3];
		int userRow = 0;
		int outPutRow = 0;
			
		for (int i = 0; i < firstUserRows  ; i++)
		{
			for (int j = 0; j < secondUserRows; j++) 
			{
		    if (firstUserMatrix[i][itemPosition] == secondUserMatrix[j][itemPosition] ) 
			    {
		    	    
			    	outputMatrix[userRow][0] = secondUserMatrix[j][1];
			    	outputMatrix[userRow][1] = firstUserMatrix[i][2];
			    	outputMatrix[userRow][2] = secondUserMatrix[j][2];
			    	if (outputMatrix[userRow][0] != 0) outPutRow++;
			    	userRow++;
			    	
			    }
			}// end inner for
		} // end outer for 	
		
		int[][] finalMatrix = new int[outPutRow][3];
		for (int k = 0; k < outPutRow; k++) {
			for (int column  = 0; column < 3; column++)
			finalMatrix[k][column] = outputMatrix[k][column];
		}
		
		
		return finalMatrix;
	 } // end method matchIdChoices
}
