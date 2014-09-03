package inProcessing;

public class Algorithms {

	public static void main(String[] args) {
		
		double[][] data = {{0,7,7,7,10}, {1,6,6,6,8}, {2,4,4,4,7},{3,5,5,5,7}, {4,3,3,3,6},{5,2,2,2,4}, {6,1,1,1,3}};
		
		double[][] result = sortMultidimensionArray(data, 1);
		
		printMatrix(result, "%4s\t");
		

	} // end main
	
	public static double[] selectionSort(double[] dataArray) {
		int minIndex;
		double tmp;
		for ( int i = 0; i < dataArray.length - 1; i++) 
		{			
			minIndex = i;			
			for (int j = i + 1; j < dataArray.length ; j++)  {
				
			 if ( dataArray[j] < dataArray[minIndex]) {
				 tmp = dataArray[minIndex];
				 dataArray[minIndex] = dataArray[j];
				 dataArray[j] = tmp;
			 } // end if
				
			} // end inner for
			
		} //end outer for
		
		
	 return dataArray;
	} //end method selectionSort
	
	
	/** 
	 * @param dataArray a multidimensional array of type double
	 * @param columnSorting the number of the column used to sort
	 * @return dataArray the multidimensional array sorted respects the columnSorting
	 * @author Paolo Ronzoni
	 */
	public static double[][] sortMultidimensionArray(double[][] dataArray, int columnSorting) {
		int numberOfColumn = dataArray[0].length;
		int minIndex;
		double tmp;
		
		for ( int i = 0; i < dataArray.length - 1; i++) 
		{			
			minIndex = i;			
			for (int j = i + 1; j < dataArray.length ; j++)  {
				
			 if ( dataArray[j][columnSorting] < dataArray[minIndex][columnSorting]) {
				 
				 for (int column = 0; column < numberOfColumn; column++) {
					tmp = dataArray[minIndex][column];
					dataArray[minIndex][column] = dataArray[j][column];
					dataArray[j][column] = tmp;}

			 } // end if				
			} // end inner for			
		} //end outer for	
		
	 return dataArray;
	} //end method sortMultidimensionArray
	
	/** Overloads printMatrix
	 * 
	 * @param an input Matrix of type double[][]
	 * @return print out the input Matrix
	 * @author Paolo Ronzoni
	 */
	public static void printMatrix(double[][] inputMatrix, String printLayout) {
	
		int nRows = inputMatrix.length;
		int nColumns = inputMatrix[0].length;
		
		System.out.println("The matrix is: ");
		for (double[] row: inputMatrix)  
		{
			for (double column: row) 
			{
				System.out.printf(printLayout, column);
			}
			System.out.println();
		}// end enanched loop
		
		System.out.println("Number of rows: " + nRows);
		System.out.println("Number of columns " + nColumns);
	} // end method matrixPrint double[][]

} // end Class
