package fileIO;


	
	
public class TestClass {
	static double[][] doubleMatrix = {{23.2, 11.5, 18.23}, 
									  {7.89, 56.1, 1.00}};
	static String path1 = "DataStore\\prova.txt";
	static String path2 = "DataStore\\doubleNumbers.txt";
	static String splitExpression = "\\s+";
	public static void main(String[] args) {
          
	String[][] myMatrix = IOMethods.txtMatrix(path2, splitExpression);
	IOMethods.printMatrix(myMatrix, "%4s\t");
	double[][] secondMatrix = IOMethods.matrixConversionDouble(myMatrix);
	double[] matrix1 = IOMethods.columnExtractor(secondMatrix, 0);
	IOMethods.printMatrix(matrix1, "%4s\t");
	IOMethods.printMatrix(secondMatrix, "%4s\t");
	
	}// end main
			
} // end Class TestClass
	



