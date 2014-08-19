package fileIO;

import fileIO.IOMethods;

public class TestClass {
	static String path1 = "DataStore\\prova.txt";
	static String path2 = "DataStore\\u1.txt";
	static String splitExpression = "\\s+";
	public static void main(String[] args) {
          
	String[][] myMatrix = IOMethods.txtMatrix(path1, splitExpression);
	IOMethods.matrixPrint(myMatrix);
	int[][] integerMatrix = IOMethods.matrixConversion(myMatrix);
	IOMethods.matrixPrint(integerMatrix);	
	
	}// end main
			
} // end Class TestClass
	



