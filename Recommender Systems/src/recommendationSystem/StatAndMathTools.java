package recommendationSystem;

public class StatAndMathTools {
	
	/** 
	 * @param inputMatrix an input matrix of type int
	 * @param columnNumber column where to do the computation
	 * @return the average of the chosen column 
	 * @author Paolo Ronzoni
	 */
	public static double matrixColumnAverage(int[][] inputMatrix, int columnNumber) {		
		
		int numberOfRows = inputMatrix.length;
		double sumOfValues = 0;
			
		for (int row = 0; row < numberOfRows  ; row++)
		{
		    sumOfValues += inputMatrix[row][columnNumber];	    
			 
		} // end outer for 		
		
		return sumOfValues/numberOfRows;
	 } // end method matrixColumnAverage
	
	/** @Overrides
	 * @param inputMatrix an input matrix of type int
	 * @param columnNumber column where to do the computation
	 * @return the average of the chosen column 
	 * @author Paolo Ronzoni
	 */
	public static double matrixColumnAverage(double[][] inputMatrix, int columnNumber) {		
		
		int numberOfRows = inputMatrix.length;
		double sumOfValues = 0;
			
		for (int row = 0; row < numberOfRows  ; row++)
		{
		    sumOfValues += inputMatrix[row][columnNumber];	    
			 
		} // end outer for 		
		
		return sumOfValues/numberOfRows;
	 } // end method matrixColumnAverage

}

