package fileIO;

public class Examples {

	public static void main(String[] args) {
	    // path birkbeck "H:\\"
		// path X1 Cargon "C:\\Users\\Paolo\\Desktop\\"
		String path = "C:\\Users\\Paolo\\Desktop\\"; 
		 String fileName = path + "data.csv";
		
		int nRows = CvsAnalyser.rowCounter(fileName);
		int nColumns = CvsAnalyser.columnCounter(fileName);
		String[][] myMatrix = CvsAnalyser.cvsMatrix(fileName, nRows, nColumns);
		Double[][] myDoubleMatrix = CvsAnalyser.matrixConversion(myMatrix);
		Double[][] myDoubleMatrixEnanched = CvsAnalyser.matrixConversion(myMatrix);
		System.out.println("Number of column: " + nColumns);
		System.out.println("Number of rows: " + nRows);
		
			
		
		 System.out.println("SIIIIIIIIIIIII");
		 
		 for (int row = 0; row < nRows; row++) 
		 {
			 for (int col = 0; col < nColumns; col++) 
			 {
				 System.out.print(myDoubleMatrix[row][col] + " ");
			 }
			 System.out.println();
		 }
		 


	} // end of main method
	
} // end of class Examples  
