package fileIO;

import fileIO.IOMethods;
	
	
public class TestClass {
	static double[][] doubleMatrix = {{23.2, 11.5, 18.23}, {7.89, 56.1, 1.00}};
	static String path1 = "DataStore\\prova.txt";
	static String path2 = "DataStore\\u1.txt";
	static String splitExpression = "\\s+";
	public static void main(String[] args) {
          
	String[][] myMatrix = IOMethods.txtMatrix(path2, splitExpression);
	IOMethods.printMatrix(myMatrix, "%4s\t");
	int[][] integerMatrix = IOMethods.matrixConversion(myMatrix);
	IOMethods.printMatrix(integerMatrix, "%4s\t");
	IOMethods.printMatrix(doubleMatrix, "%4s\t");
	
	}// end main
			
} // end Class TestClass
	



