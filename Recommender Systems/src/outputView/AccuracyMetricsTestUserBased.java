package outputView;

import recommendationSystem.AccuracyMetricsUserBased;
import recommendationSystem.MatrixBuilder;
import recommendationSystem.UserBasedNearestNeighbor;
import evaluationMetrics.MeanAbsoluteError;
import fileIO.IOMethods;

public class AccuracyMetricsTestUserBased {

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
		int userSearched = 2;
		int [][] solutionMatrix = MatrixBuilder.userIDchoices(secondMatrix, 0, userSearched);
	 IOMethods.printMatrix(solutionMatrix, "%4s\t");
	 
	 double result;
	 
	 for (int i = 1; i < 300 ; i++) {
		// meanAbsoluteErrorUserBasedOneUser, normalizedMeanAbsoluteErrorUserBasedOneUser, rootMeanSquaredErrorUserBasedOneUser
		result = AccuracyMetricsUserBased.meanAbsoluteErrorUserBasedOneUser(secondMatrix, 0, i, 1, 5);
		System.out.println("il risultato num." + i + " is: " + result);
	}
	System.out.println("End of computation");
	 
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
