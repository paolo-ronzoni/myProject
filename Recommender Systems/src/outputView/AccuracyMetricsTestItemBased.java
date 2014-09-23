package outputView;

import java.util.Date;



import recommendationSystem.AccuracyMetricsItemBased;
import recommendationSystem.AccuracyMetricsUserBased;
import recommendationSystem.MatrixBuilder;
import recommendationSystem.StatAndMathTools;
import recommendationSystem.UserBasedNearestNeighbor;
import evaluationMetrics.MeanAbsoluteError;
import fileIO.IOMethods;

public class AccuracyMetricsTestItemBased {

	static String path1 = "DataStore\\u.txt";
	static String path2 = "DataStore\\bookDataTab2dot1.txt";
	static String splitExpression = "\\s+";
	
	
	public static void main(String[] args) {
		
		Date date = new Date();

		String[][] myMatrix = IOMethods.txtMatrix(path1, splitExpression);
		// IOMethods.printMatrix(myMatrix, "%4s\t");
		int[][] secondMatrix = IOMethods.matrixConversion(myMatrix);
		// int[] matrix1 = IOMethods.columnExtractor(secondMatrix, 0);
		// IOMethods.printMatrix(secondMatrix, "%4s\t");


//		int elementFounded = MatrixBuilder.numberOfElement(secondMatrix, 0, 186);
//		System.out.println("element founded: " + elementFounded);
//		System.out.println("matrix length: " + secondMatrix.length);
		int userSearched = 2;
//		int [][] solutionMatrix = MatrixBuilder.userIDchoices(secondMatrix, 0, userSearched);
//	 IOMethods.printMatrix(solutionMatrix, "%4s\t");
	 
	 double result;
	 
	 // start time
	 StatAndMathTools.getTime("Start time");
	 for (int i = 47; i < 48 ; i++) {
		// meanAbsoluteErrorItemBasedOneUser, normalizedMeanAbsoluteErrorItemBasedOneUser, rootMeanSquaredErrorItemBasedOneUser
		result = AccuracyMetricsItemBased.meanAbsoluteErrorItemBasedOneUser(secondMatrix, 0, i, 1, 3);
		System.out.println("il risultato num." + i + " is: " + result);
	}
	 // end time
	 StatAndMathTools.getTime("End time");
	 
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
