package recSystem;

public class MatrixBuilder {

	
	/** 
	 * by Paolo Ronzoni
	 * @param inputMatrix an input matrix of type int
	 * @param columnNumber the number of the column
	 * @return outputArray an array of the column extracts
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
	 } // end method columnExtractor

}
