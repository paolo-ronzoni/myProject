package fileIO;

import fileIO.IOTextFiles;

public class TestClass {
	static String path1 = "DataStore\\prova.txt";
	static String splitExpression = "\\s+";
	public static void main(String[] args) {
          
		String[][] myMatrix = IOTextFiles.txtMatrix(path1, splitExpression);
		IOTextFiles.matrixPrint(path1, splitExpression);
		int[][] integerMatrix = IOTextFiles.matrixConversion(myMatrix);
		
	
	}// end main
			
} // end Class TestClass
	



