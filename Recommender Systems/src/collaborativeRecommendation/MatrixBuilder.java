package collaborativeRecommendation;

public class MatrixBuilder {

	
	/** Overloads columnExtractor
	 * by Paolo Ronzoni
	 * @param inputMatrix an input matrix of type double[][]
	 * @param columnNumber the number of the column
	 * @return outputArray an array of the column extracts
	 */
	public static double[] columnExtractor(double[][] inputMatrix, int columnNumber) {
		int nRows = inputMatrix.length;
		double[] outputArray = new double[nRows ];
		for (int row = 0; row < nRows; row++)
		{
		    outputArray[row] = inputMatrix[row][columnNumber];		    
		} 			 
		return outputArray;
	 } // end method columnExtractor
}
