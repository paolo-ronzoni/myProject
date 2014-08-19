package fileIO;

import fileIO.IOFileMethods;

public class TestClass {
	static String path1 = "DataStore\\prova.txt";
	static String path2 = "DataStore\\u1.txt";
	static String splitExpression = "\\s+";
	public static void main(String[] args) {
          
	String[][] myMatrix = IOFileMethods.txtMatrix(path1, splitExpression);
	IOFileMethods.matrixPrint(myMatrix);
	int[][] integerMatrix = IOFileMethods.matrixConversion(myMatrix);
		
	
	}// end main
			
} // end Class TestClass
	



