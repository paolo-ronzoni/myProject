package fileIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CvsAnalyser {
	
	// this is a comment
	// this is a second comment
	
	/**
	 * @param filePath location of the .cvs path
	 * @return number of rows in a .cvs file
	 */
	public static int rowCounter(String filePath)
	 {
		 int numRow = 0;
		 File afile = new File(filePath);
		 Scanner inputStream;
		 try 
		 {
			 inputStream = new Scanner(afile);
			 while (inputStream.hasNext())
			    {   
				 inputStream.nextLine();
				 numRow++;
			    }
			 inputStream.close(); 
		 }
		 catch (FileNotFoundException e) 
		 {
			  e.printStackTrace();
			 
		 }
		 
		 return numRow;
	 } // end method rowCounter
	
	/**
	 * @param filePath location of the .cvs path
	 * @return number of column in a .cvs file
	 */
	public static int columnCounter(String filePath)
	 {
		 int numColumn = 0;
		 File afile = new File(filePath);
		 Scanner inputStream;
		 try 
		 {
			 inputStream = new Scanner(afile);
			 String data = inputStream.nextLine();   
			 String[] values = data.split(",");
			 numColumn = values.length;
			 inputStream.close(); 
		 }
		 catch (FileNotFoundException e) 
		 {
			  e.printStackTrace();
			 
		 }
		 
		 return numColumn;
	 } // end method columnCounter

	/**
	 * 
	 * @param filePath location of the .txt file
	 * @param nRows number of rows in the cvs file
	 * @param nColumns number of columns int the .cvs file
	 * @return number of column in a .cvs file
	 */
	public static String[][] cvsMatrix(String filePath, int nRows, int nColumns)
	 {
		File afile = new File(filePath);
		 Scanner inputStream;
		 String[][] cvsMatrix = new String[nRows ][nColumns];
		try {
			  inputStream = new Scanner(afile);
			  String data;
			  String[] values;
				   for (int row = 0; row < nRows ; row++)
				   {
					    data = inputStream.nextLine();//gets a whole line
					    values = data.split(",");
					    for (int column = 0; column < values.length; column++)
					    {
					    		cvsMatrix[row][column] = values[column] ;
					    }
				   }
				   inputStream.close(); 
			}
				    catch (FileNotFoundException e) 
					 {
						  e.printStackTrace();
						 
					 }
					 
					 return cvsMatrix;
				 } // end method cvsMatrix
	
	/**
	 * @param stringMatrix A bi-dimensinal string matrix.
	 * @return a bi-dimensional double matrix.
	 */
	public static Double[][] matrixConversion(String[][] stringMatrix)
	 {
		int nRows = stringMatrix.length;
		int nColumns = stringMatrix[0].length;
		Double[][] doubleMatrix = new Double[nRows ][nColumns];
		for (int row = 0; row < nRows; row++)
		{
		    for (int column = 0; column < nColumns; column++)
		    {
		     doubleMatrix[row][column] = Double.parseDouble(stringMatrix[row][column]);
		    }
		} 			 
					 return doubleMatrix;
	 } // end method matrixConversion
	
	/**
	 * @param stringMatrix A bi-dimensinal string matrix.
	 * @return A bi-dimensional double matrix.
	 */
	public static Double[][] matrixConversionEnanched(String[][] stringMatrix)
	 {
		int nRows = stringMatrix.length;
		int nColumns = stringMatrix[0].length;
		Double[][] doubleMatrix = new Double[nRows ][nColumns];
		for (String[] row: stringMatrix)
		{
		    for (String[] column: stringMatrix)
		    {
		     //doubleMatrix[row][column] = Double.parseDouble(stringMatrix[row][column]);
		    }
		} 			 
		return doubleMatrix;
	 } // end method matrixConversionEnanched
	
} // end Class
