package fileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class IOMethods<T> {

	
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
	 * @param nColumns number of columns int the .cvs file
	 * @return A matrix of type String[][]
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
	 * @param stringMatrix A matrix of type String[][]
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
	 * @param an input Matrix of type String[][]
	 * @return print the input Matrix
	 */
	public static  void printMatrix(String[][] inputMatrix, String printLayout) {
		int nRows = inputMatrix.length;
		int nColumns = inputMatrix[0].length;
		
		System.out.println("The matrix is: ");
		for (String[] row: inputMatrix)  
		{
			for (String column: row)
			{
				System.out.printf(printLayout, column);
			}
			System.out.println();
		}// end enanched loop
		
		System.out.println("Number of rows: " + nRows);
		System.out.println("Number of columns " + nColumns);
	} // end method matrixPrint
	
	
	/** Overloads printMatrix
	 * by Paolo Ronzoni
	 * @param an input Matrix of type int[][]
	 * @return print out the input Matrix
	 */
	public static void printMatrix(int[][] inputMatrix, String printLayout) {
	
		int nRows = inputMatrix.length;
		int nColumns = inputMatrix[0].length;
		
		System.out.println("The matrix is: ");
		for (int[] row: inputMatrix)  
		{
			for (int column: row) 
			{
				System.out.printf(printLayout, column);
			}
			System.out.println();
		}// end enanched loop
		
		System.out.println("Number of rows: " + nRows);
		System.out.println("Number of columns " + nColumns);
	} // end method matrixPrint int[][]
	
	/** Overloads printMatrix
	 * by Paolo Ronzoni
	 * @param an input Matrix of type double[][]
	 * @return print out the input Matrix
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
	
} //end Class IOMethods