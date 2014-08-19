package fileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class IOMethods {

	
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
	 * @param inputMatrix an input matrix of type String[][]
	 * @return outputMatrix a matrix of type integer
	 */
	public static int[][] matrixConversion(String[][] inputMatrix)
	 {
		int nRows = inputMatrix.length;
		int nColumns = inputMatrix[0].length;
		int[][] outputMatrix = new int[nRows ][nColumns];
		for (int row = 0; row < nRows; row++)
		{
		    for (int column = 0; column < nColumns; column++)
		    {
		     outputMatrix[row][column] = Integer.parseInt(inputMatrix[row][column]);
		    }
		} 			 
		return outputMatrix;
	 } // end method matrixConversion
	
	
	/**
	 * by Paolo Ronzoni
	 * @param inputMatrix an input matrix of type String[][]
	 * @return outputMatrix a matrix of type double
	 */
	public static double[][] matrixConversionDouble(String[][] inputMatrix)
	 {
		int nRows = inputMatrix.length;
		int nColumns = inputMatrix[0].length;
		double[][] outputMatrix = new double[nRows ][nColumns];
		for (int row = 0; row < nRows; row++)
		{
		    for (int column = 0; column < nColumns; column++)
		    {
		     outputMatrix[row][column] = Double.parseDouble(inputMatrix[row][column]);
		    }
		} 			 
		return outputMatrix;
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
	 * @param an input columMatrix of type int[]
	 * @return print out the column values
	 */
	public static void printMatrix(int[] inputMatrix, String printLayout) {
	
		int nRows = inputMatrix.length;
		
		System.out.println("The column matrix is: ");
		for (int row: inputMatrix)  
		{
			System.out.printf(printLayout, row);
			System.out.println();
		}// end enanched loop
		
		System.out.println("Number of rows: " + nRows);
		
	} // end method printMatrix int[][]
	
	
	/** Overloads printMatrix
	 * by Paolo Ronzoni
	 * @param an input columMatrix of type double[]
	 * @return print out the column values
	 */
	public static void printMatrix(double[] inputMatrix, String printLayout) {
	
		int nRows = inputMatrix.length;
		
		System.out.println("The column matrix is: ");
		for (double row: inputMatrix)  
		{
			System.out.printf(printLayout, row);
			System.out.println();
		}// end enanched loop
		
		System.out.println("Number of rows: " + nRows);
		
	} // end method printMatrix int[][]
	
	
	
	
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
	
	/**
	 * by Paolo Ronzoni
	 * @param inputMatrix an input matrix of type int[][]
	 * @param columnNumber the number of the column
	 * @return outputArray an array of the column extracts
	 */
	public static int[] columnExtractor(int[][] inputMatrix, int columnNumber)
	 {
		int nRows = inputMatrix.length;
		int[] outputArray = new int[nRows ];
		for (int row = 0; row < nRows; row++)
		{
		    
		    outputArray[row] = inputMatrix[row][columnNumber];
		    
		} 			 
		return outputArray;
	 } // end method columnExtractor
	
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
	
} //end Class IOMethods