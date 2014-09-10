package outputView;

import recommendationSystem.AccuracyMetrics;
import recommendationSystem.MatrixBuilder;
import recommendationSystem.UserBasedNearestNeighbor;
import evaluationMetrics.MeanAbsoluteError;
import fileIO.IOMethods;

public class AccuracyMetricsTestResult {

	static String path1 = "DataStore\\u.txt";
	static String path2 = "DataStore\\bookDataTab2dot1.txt";
	static String splitExpression = "\\s+";
	
	
	public static void main(String[] args) {

		String[][] myMatrix = IOMethods.txtMatrix(path1, splitExpression);
		// IOMethods.printMatrix(myMatrix, "%4s\t");
		int[][] secondMatrix = IOMethods.matrixConversion(myMatrix);
		// int[] matrix1 = IOMethods.columnExtractor(secondMatrix, 0);
		// IOMethods.printMatrix(secondMatrix, "%4s\t");


//		int elementFounded = MatrixBuilder.numberOfElement(secondMatrix, 0, 186);
//		System.out.println("element founded: " + elementFounded);
//		System.out.println("matrix length: " + secondMatrix.length);
		int [][] solutionMatrix = MatrixBuilder.matchIDchoices(secondMatrix, 0, 1, 2);
	 IOMethods.printMatrix(solutionMatrix, "%4s\t");
	 
	 double result = AccuracyMetrics.meanAbsoluteErrorUserBasedOneUser(secondMatrix, 0, 1, 1, 2);
	 System.out.println("il risultato e': " + result);
//	 double nearestValue = 0;
//	 for (int k = 1; k <= 5; k++ ) 
//	 {
//		 nearestValue = UserBasedNearestNeighbor.userNearestNeighborValue(secondMatrix, 0, 1, k);
//		 // if (Double.isNaN(nearestValue)) {
//		 System.out.println("value(1," + k + "): " + nearestValue);
//		 //}
//	 } //end for;

	}

}
