package recommendationSystem;

public class MatrixBuilder {

	
	/** 
	 * @param inputMatrix an input matrix of type int
	 * @param columnNumber position of the column where to search
	 * @param elementSearched the integer searched
	 * @return number of integer founded in the column
	 * @author Paolo Ronzoni
	 */
	public static int numberOfElement(int[][] inputMatrix, int columnNumber, int elementSearched) {
		int nRows = inputMatrix.length;
		int numberOfElement = 0;
		
		for (int row = 0; row < nRows; row++)
		{
		    if (inputMatrix[row][columnNumber] == elementSearched) 
		    	numberOfElement++;
		} 			 
		return numberOfElement;
	 } // end method numberOfElement
	
	
	/** 
	 * @param inputMatrix an input matrix of type int
	 * @param columnNumber position of the column where to search
	 * @param elementSearched the integer searched
	 * @return a three column matrix with the choices of two users
	 * @author Paolo Ronzoni
	 */
	public static int[][] userIDchoices(int[][] inputMatrix, int columnNumber, int elementSearched) {
		int nRows = inputMatrix.length;
		int nRowsUser = numberOfElement(inputMatrix, columnNumber, elementSearched);
		int[][] outputMatrix = new int[nRowsUser][3];
		int userRow = 0;
		for (int row = 0; row < nRows; row++)
		{
		    if (inputMatrix[row][columnNumber] == elementSearched) 
		    {
		    	for (int column = 0; column < 3; column++) {
		    	outputMatrix[userRow][column] = inputMatrix[row][column];
		    	}
		    	userRow++;
		    }
		    
		} 			 
		return outputMatrix;
	 } // end method userIdChoices
	
	
	/** 
	 * @param inputMatrix an input matrix of type int
	 * @param columnNumber position of the column where to search
	 * @param elementSearched the integer searched
	 * @return a three column matrix with userID, ItemId, rating
	 * @author Paolo Ronzoni
	 */
	public static int[][] singleUserIDchoices(int[][] inputMatrix, int columnNumber, int elementSearched) {
		int nRows = inputMatrix.length;
		int nRowsUser = numberOfElement(inputMatrix, columnNumber, elementSearched);
		int[][] intermediateMatrix = new int[nRowsUser][3];
		int userRow = 0;
		//int outPutRow = 0;
		for (int row = 0; row < nRows; row++)
		{
		    if (inputMatrix[row][columnNumber] == elementSearched) 
		    {
		    	for (int column = 0; column < 3; column++) {
		    	intermediateMatrix[userRow][column] = inputMatrix[row][column];
		    	}
		    	userRow++;
		    }
		    
		} 			 
		return intermediateMatrix;
	 } // end method singleUserIdChoices
	
	
	/** 
	 * @param inputMatrix an input matrix of type int
	 * @param columnNumber position of the column where to search
	 * @param firstelementSearched the first user searched
	 * @param secondelementSearched the second user searched
	 * @return a three column matrix with the common choices of the two users
	 * @author Paolo Ronzoni
	 */
	public static int[][] matchIDchoices(int[][] inputMatrix, int columnNumber, int firstElementSearched, int secondElementSearched) {		
		
		int[][] firstUserMatrix = userIDchoices(inputMatrix, columnNumber, firstElementSearched);
		int[][] secondUserMatrix = userIDchoices(inputMatrix, columnNumber, secondElementSearched);
		int firstUserRows = firstUserMatrix.length;
		int secondUserRows = secondUserMatrix.length;
		int itemPosition = 1;
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
