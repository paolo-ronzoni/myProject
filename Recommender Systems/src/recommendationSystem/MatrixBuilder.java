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
	 * 
	 * @param inputMatrix an input matrix of type int
	 * @param columnNumber position of the column where to search
	 * @param elementSearched the integer searched
	 * @return a three column matrix with the choices of an user
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
	 * 
	 * @param inputMatrix an input matrix of type int
	 * @param columnNumber position of the column where to search
	 * @param firstelementSearched the first user searched
	 * @param secondelementSearched the second user searched
	 * @return a three column matrix with the common choices of the tow users
	 * @author Paolo Ronzoni
	 */
	public static int[][] matchIDchoices(int[][] inputMatrix, int columnNumber, int firstElementSearched, int secondElementSearched) {
		
		int[][] firstUser = userIDchoices(inputMatrix, columnNumber, firstElementSearched);
		int[][] secondUser = userIDchoices(inputMatrix, columnNumber, secondElementSearched);
		
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
