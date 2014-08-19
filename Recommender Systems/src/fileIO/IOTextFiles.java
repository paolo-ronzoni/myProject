package fileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class IOTextFiles {

	
	/**
	 * @param filePath location of the .txt file
	 * @return number of rows in the .txt file
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
	 * @param filePath location of the .txt file
	 * @param splitExpression "expression" that split the table
	 * @return number of column in a .txt file
	 */
	public static int columnCounter(String filePath, String splitExpression)
	 {
		 int numColumn = 0;
		 File afile = new File(filePath);
		 Scanner inputStream;
		 try 
		 {
			 inputStream = new Scanner(afile);
			 String data = inputStream.nextLine();   
			 String[] values = data.split(splitExpression); // expression for space "\\s+"
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
	 * by Paolo Ronzoni
	 * @param filePath location of the .txt file
	 * @param nRows number of rows in the .txt file
	 * @param nColumns number of columns int the .cvs file
	 * @return A String matrix
	 */
	public static String[][] txtMatrix(String filePath, String splitExpression)
	 {
		int nRows = rowCounter(filePath);
		int nColumns = columnCounter(filePath, splitExpression);
		
		File afile = new File(filePath);
		 Scanner inputStream;
		 String[][] txtMatrix = new String[nRows ][nColumns];
		try {
			  inputStream = new Scanner(afile);
			  String data;
			  String[] values;
				   for (int row = 0; row < nRows ; row++)
				   {
					    data = inputStream.nextLine();//gets a whole line
					    values = data.split(splitExpression);
					    for (int column = 0; column < values.length; column++)
					    {
					    		txtMatrix[row][column] = values[column] ;
					    }
				   }
				   inputStream.close(); 
			}
				    catch (FileNotFoundException e) 
					 {
						  e.printStackTrace();
						 
					 }
					 
					 return txtMatrix;
				 } // end method txtMatrix
	
	/**
	 * by Paolo Ronzoni
	 * @param stringMatrix A bi-dimensinal string matrix.
	 * @return a bi-dimensional integer matrix.
	 */
	public static int[][] matrixConversion(String[][] stringMatrix)
	 {
		int nRows = stringMatrix.length;
		int nColumns = stringMatrix[0].length;
		int[][] integerMatrix = new int[nRows ][nColumns];
		for (int row = 0; row < nRows; row++)
		{
		    for (int column = 0; column < nColumns; column++)
		    {
		     integerMatrix[row][column] = Integer.parseInt(stringMatrix[row][column]);
		    }
		} 			 
					 return integerMatrix;
	 } // end method matrixConversion
	

	/**
	 * by Paolo Ronzoni
	 * @param filePath location of the .txt file
	 * @param splitExpression the characters used to separate sigle elements in a row
	 * @return Print a matrix of type String element
	 */
	public static void txtMatrixPrint(String filePath, String splitExpression) {
	
	int nRows = rowCounter(filePath);
	int nColumns = columnCounter(filePath, splitExpression);	
	String[][] stringMatrix = txtMatrix(filePath, splitExpression);
	
	System.out.println("The stringMatrix is: ");
	for (int i = 0; i < nRows; i++)  {
		//System.out.print((i + 1) + ": ");
		for (int j = 0; j < nColumns; j++)
		{
			System.out.printf("%4s\t", stringMatrix[i][j]);
		}
		System.out.println();
	}// end for
	System.out.println("Number of rows: " + nRows);
	System.out.println("Number of columns " + nColumns);
	} // end method txtMatrixTest
	
} //end class ReadTXTPaolo