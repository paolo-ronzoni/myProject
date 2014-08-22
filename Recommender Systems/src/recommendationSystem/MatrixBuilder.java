package recommendationSystem;

public class MatrixBuilder {

	
	/** 
	 * by Paolo Ronzoni
	 * @param inputMatrix an input matrix of type int
	 * @param columnNumber position of the column where to search
	 * @param elementSearched the integer searched
	 * @return number of integer founded in the column
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
	 * by Paolo Ronzoni
	 * @param inputMatrix an input matrix of type int
	 * @param columnNumber position of the column where to search
	 * @param elementSearched the integer searched
	 * @return number of integer founded in the column
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
	

}
