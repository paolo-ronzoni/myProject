package recommendationSystem;

import fileIO.IOMethods;
import inProcessing.Algorithms;

import java.util.Arrays;

import sun.swing.MenuItemLayoutHelper.ColumnAlignment;

public class UserBasedNearestNeighbor {

	
	/** 
	 * @param inputMatrix an input matrix of type int
	 * @param columnNumber the position of the column where to search the user
	 * @param firstElementSearched the first user searched
	 * @param secondElementSearched the second user searched
	 * @return 
	 * @author Paolo Ronzoni
	 */
	public static double userNearestNeighborValue(int[][] inputMatrix, int columnNumber, int firstElementSearched, int secondElementSearched) {		
		
		// create a matrix of three column: items, user1scores, user2scores
		int[][] intermediateMatrix = MatrixBuilder.matchIDchoices(inputMatrix, columnNumber,firstElementSearched, secondElementSearched);
		
		int user1columnScores = 1;
		int user2columnScores = 2;
		int numRows = intermediateMatrix.length;
		double numerator = 0;
		double denominator1 = 0;
		double denominator2 = 0;
		
		// calculates the averages of the columns' users scores 
		double user1Average = StatAndMathTools.matrixColumnAverage(intermediateMatrix, user1columnScores);
		double user2Average = StatAndMathTools.matrixColumnAverage(intermediateMatrix, user2columnScores);
		
		
		for (int row = 0; row < numRows  ; row++)
		{
		numerator += ((intermediateMatrix[row][user1columnScores] - user1Average) * (intermediateMatrix[row][user2columnScores] - user2Average));
		
		denominator1 += Math.pow((intermediateMatrix[row][user1columnScores] - user1Average),2);
		denominator2 += Math.pow((intermediateMatrix[row][user2columnScores] - user2Average),2);
			    	
		} // end for loop
		
		
		return (numerator / (Math.sqrt(denominator1 * denominator2)));
	 } // end method userNearestNeighborValue
	
	
	
	
	/** 
	 * @param inputMatrix an input matrix of type int
	 * @param usercolumnNumber the position of the column where to search the user
	 * @param firstElementSearched the  user searched
	 * @param itemcolumnNumber the position of the column where to search the item
	 * @param itemSearched the item searched
	 * @param numOfNearestNeighbor the number of similarity to use to calculate the predictionUserBasedValue
	 * @return double the prediction of the rating for the item searched for the specific user
	 * @author Paolo Ronzoni
	 */
	public static double predictionUserBasedValue(int[][] inputMatrix, int userColumnNumber, int userSearched, int itemcolumnNumber, int itemSearched, int numOfNearestNeighbor) {		
		
		// find all users, without duplication, in the inputMatrix
		int[] usersVector = MatrixBuilder.findAllUsers(inputMatrix, userColumnNumber);
		
		// swap the userSearched position at the beginning of the usersVector
		for ( int i = 0; i < usersVector.length; i++) {
			if ( usersVector[i] == userSearched) {
				int tmp = usersVector[0];
				usersVector[0] = userSearched;
				usersVector[i] = tmp;
				break;
			}
		} // end for s
		
		// creates a matrix of three column: userSearched, allOtherUsers, userNearestNeighborValue
		double[][] intermediateMatrix = new double[usersVector.length -1][3];
		for (int row = 0; row < usersVector.length -1 ; row++) {
			intermediateMatrix[row][0] = userSearched;
			intermediateMatrix[row][1] = usersVector[row + 1];
			intermediateMatrix[row][2] = userNearestNeighborValue( inputMatrix, userColumnNumber,  userSearched, usersVector[row + 1]);
		}
		
		// orders the intermediateMatrix respect to userNearestNeighborValue
				int lastMatrixColumn = 5;
				double[][] finalMatrix = StatAndMathTools.sortMultidimensionArray(intermediateMatrix, 2);
				double[][] lastMatrix = new double[numOfNearestNeighbor][lastMatrixColumn];
				int lastRow = finalMatrix.length -1;
				double[][] forMatrix;
				outerloop:
				for ( int i = 0; i < numOfNearestNeighbor; i++) {	 
					forMatrix = MatrixBuilder.userIDchoicesDouble(inputMatrix, userColumnNumber,(int) finalMatrix[lastRow][1]);
					 while( Double.isNaN(finalMatrix[lastRow][2]) || 
							 !MatrixBuilder.isThereItem(forMatrix, 1, itemSearched)) {
						lastRow -= 1;
						if(lastRow < 0 ) break outerloop;
						forMatrix = MatrixBuilder.userIDchoicesDouble(inputMatrix, userColumnNumber,(int) finalMatrix[lastRow][1]);
					
					} // end while
					 // if(lastRow < 0 ) break outerloop;
					 lastMatrix[i][0] = finalMatrix[lastRow][0]; // the user searched
					 lastMatrix[i][1] = finalMatrix[lastRow][1]; // an other users
					 lastMatrix[i][4] = finalMatrix[lastRow][2];
					 
					 lastMatrix[i][2] = MatrixBuilder.getItem(forMatrix, 1, itemSearched, 2);
					 lastMatrix[i][3] = StatAndMathTools.matrixColumnAverage(forMatrix,2 );
					 lastRow--;

				} // end for
		
		
		
		int user1ColumnScores = 2;
		int numRows = lastMatrix.length;
		int lastMatrixSimColumn = 4;
		int lastMatrixScoresColumn = 2;
		int lastMatrixAveragesColumn = 3;
		double numerator = 0;
		double denominator = 0;
	
		
		// calculates the averages of the firt users
		double user1Average = StatAndMathTools.matrixColumnAverage(MatrixBuilder.userIDchoicesDouble(inputMatrix, userColumnNumber, userSearched),user1ColumnScores);

		
		
		for (int row = 0; row < numRows  ; row++)
		{
		numerator += lastMatrix[row][lastMatrixSimColumn] * (lastMatrix[row][lastMatrixScoresColumn] - lastMatrix[row][lastMatrixAveragesColumn]);
		
		denominator += lastMatrix[row][lastMatrixSimColumn];
		
			    	
		} // end for loop
		
		 return user1Average + (numerator / denominator);
		// return lastMatrix;
	 } // end method predictionUserBasedValue
	
	/** 
	 * @param inputMatrix an input matrix of type int
	 * @param usercolumnNumber the position of the column where to search the user
	 * @param firstElementSearched the  user searched
	 * @param itemcolumnNumber the position of the column where to search the item
	 * @param itemSearched the item searched
	 * @param numOfNearestNeighbor the number of similarity to use to calculate the predictionUserBasedValue
	 * @return double the prediction of the rating for the item searched for the specific user
	 * @author Paolo Ronzoni
	 */
	public static double[][] TMPpredictionUserBasedValue(int[][] inputMatrix, int userColumnNumber, int userSearched, int itemcolumnNumber, int itemSearched, int numOfNearestNeighbor) {		
		
		// find all users, without duplication, in the inputMatrix
		int[] usersVector = MatrixBuilder.findAllUsers(inputMatrix, userColumnNumber);
		
		// swap the userSearched position at the beginning of the usersVector
		for ( int i = 0; i < usersVector.length; i++) {
			if ( usersVector[i] == userSearched) {
				int tmp = usersVector[0];
				usersVector[0] = userSearched;
				usersVector[i] = tmp;
				break;
			}
		} // end for s
		
		// creates a matrix of three column: userSearched, allOtherUsers, userNearestNeighborValue
		double[][] intermediateMatrix = new double[usersVector.length -1][3];
		for (int row = 0; row < usersVector.length -1 ; row++) {
			intermediateMatrix[row][0] = userSearched;
			intermediateMatrix[row][1] = usersVector[row + 1];
			intermediateMatrix[row][2] = userNearestNeighborValue( inputMatrix, userColumnNumber,  userSearched, usersVector[row + 1]);
		}
		
		// orders the intermediateMatrix respect to userNearestNeighborValue
		int lastMatrixColumn = 5;
		double[][] finalMatrix = StatAndMathTools.sortMultidimensionArray(intermediateMatrix, 2);
		double[][] lastMatrix = new double[numOfNearestNeighbor][lastMatrixColumn];
		int lastRow = finalMatrix.length - 1;
		double[][] forMatrix;
		for ( int i = 0; i < numOfNearestNeighbor; i++) {	 
			forMatrix = MatrixBuilder.userIDchoicesDouble(inputMatrix, userColumnNumber,(int) finalMatrix[lastRow][1]);
			 while( Double.isNaN(finalMatrix[lastRow][2]) || 
					 !MatrixBuilder.isThereItem(forMatrix, 1, itemSearched)) {
				lastRow -= 1;
				forMatrix = MatrixBuilder.userIDchoicesDouble(inputMatrix, userColumnNumber,(int) finalMatrix[lastRow][1]);
			
			} // end while
			 
			// forMatrix is a  matrix of three column userID, itemID, rating
			 

			 // || !MatrixBuilder.isThereItem(forMatrix, 1, 5)
		     // if () {
			 lastMatrix[i][0] = finalMatrix[lastRow][0]; // the user searched
			 lastMatrix[i][1] = finalMatrix[lastRow][1]; // an other users
			 lastMatrix[i][4] = finalMatrix[lastRow][2];
			 
			 lastMatrix[i][2] = MatrixBuilder.getItem(forMatrix, 1, itemSearched, 2);
			 lastMatrix[i][3] = StatAndMathTools.matrixColumnAverage(forMatrix,2 );
			 lastRow--;
//		     } else {
//				lastRow--;
//			  }
		} // end for
		
		
		
		int user1columnScores = 1;
		int user2columnScores = 2;
		int numRows = intermediateMatrix.length;
		double numerator = 0;
		double denominator1 = 0;
		double denominator2 = 0;
		
		// calculates the averages of the columns' users scores 
		double user1Average = StatAndMathTools.matrixColumnAverage(intermediateMatrix, user1columnScores);
		double user2Average = StatAndMathTools.matrixColumnAverage(intermediateMatrix, user2columnScores);
		
		
		for (int row = 0; row < numRows  ; row++)
		{
		numerator += ((intermediateMatrix[row][user1columnScores] - user1Average) * (intermediateMatrix[row][user2columnScores] - user2Average));
		
		denominator1 += Math.pow((intermediateMatrix[row][user1columnScores] - user1Average),2);
		denominator2 += Math.pow((intermediateMatrix[row][user2columnScores] - user2Average),2);
			    	
		} // end for loop
		
		
		return finalMatrix;
	 } // end method TMPpredictionUserBasedValue
	
	
	/** 
	 * @param inputMatrix an input matrix of type int
	 * @param usercolumnNumber the position of the column where to search the user
	 * @param firstElementSearched the  user searched
	 * @param itemcolumnNumber the position of the column where to search the item
	 * @param itemSearched the item searched
	 * @param numOfNearestNeighbor the number of similarity to use to calculate the predictionUserBasedValue
	 * @return double the prediction of the rating for the item searched for the specific user
	 * @author Paolo Ronzoni
	 */
	public static double OriginalpredictionUserBasedValue(int[][] inputMatrix, int userColumnNumber, int userSearched, int itemcolumnNumber, int itemSearched, int numOfNearestNeighbor) {		
		
		// find all users, without duplication, in the inputMatrix
		int[] usersVector = MatrixBuilder.findAllUsers(inputMatrix, userColumnNumber);
		
		// swap the userSearched position at the beginning of the usersVector
		for ( int i = 0; i < usersVector.length; i++) {
			if ( usersVector[i] == userSearched) {
				int tmp = usersVector[0];
				usersVector[0] = userSearched;
				usersVector[i] = tmp;
				break;
			}
		} // end for s
		
		// creates a matrix of three column: userSearched, allOtherUsers, userNearestNeighborValue
		double[][] intermediateMatrix = new double[usersVector.length -1][3];
		for (int row = 0; row < usersVector.length -1 ; row++) {
			intermediateMatrix[row][0] = userSearched;
			intermediateMatrix[row][1] = usersVector[row + 1];
			intermediateMatrix[row][2] = userNearestNeighborValue( inputMatrix, userColumnNumber,  userSearched, usersVector[row + 1]);
		}
		
		// orders the intermediateMatrix respect to userNearestNeighborValue
				int lastMatrixColumn = 5;
				double[][] finalMatrix = StatAndMathTools.sortMultidimensionArray(intermediateMatrix, 2);
				double[][] lastMatrix = new double[numOfNearestNeighbor][lastMatrixColumn];
				int lastRow = finalMatrix.length -1;
				double[][] forMatrix;
				for ( int i = 0; i < numOfNearestNeighbor; i++) {	 
					forMatrix = MatrixBuilder.userIDchoicesDouble(inputMatrix, userColumnNumber,(int) finalMatrix[lastRow][1]);
					 while( Double.isNaN(finalMatrix[lastRow][2]) || 
							 !MatrixBuilder.isThereItem(forMatrix, 1, itemSearched)) {
						lastRow -= 1;
						forMatrix = MatrixBuilder.userIDchoicesDouble(inputMatrix, userColumnNumber,(int) finalMatrix[lastRow][1]);
					
					} // end while
					 
					// forMatrix is a  matrix of three column userID, itemID, rating
					 

					 // || !MatrixBuilder.isThereItem(forMatrix, 1, 5)
				     // if () {
					 lastMatrix[i][0] = finalMatrix[lastRow][0]; // the user searched
					 lastMatrix[i][1] = finalMatrix[lastRow][1]; // an other users
					 lastMatrix[i][4] = finalMatrix[lastRow][2];
					 
					 lastMatrix[i][2] = MatrixBuilder.getItem(forMatrix, 1, itemSearched, 2);
					 lastMatrix[i][3] = StatAndMathTools.matrixColumnAverage(forMatrix,2 );
					 lastRow--;
//				     } else {
//						lastRow--;
//					  }
				} // end forr
		
		
		
		int user1ColumnScores = 2;
		int numRows = lastMatrix.length;
		int lastMatrixSimColumn = 4;
		int lastMatrixScoresColumn = 2;
		int lastMatrixAveragesColumn = 3;
		double numerator = 0;
		double denominator = 0;
	
		
		// calculates the averages of the firt users
		double user1Average = StatAndMathTools.matrixColumnAverage(MatrixBuilder.userIDchoicesDouble(inputMatrix, userColumnNumber, userSearched),user1ColumnScores);

		
		
		for (int row = 0; row < numRows  ; row++)
		{
		numerator += lastMatrix[row][lastMatrixSimColumn] * (lastMatrix[row][lastMatrixScoresColumn] - lastMatrix[row][lastMatrixAveragesColumn]);
		
		denominator += lastMatrix[row][lastMatrixSimColumn];
		
			    	
		} // end for loop
		
		 return user1Average + (numerator / denominator);
		// return lastMatrix;
	 } // end method OriginalpredictionUserBasedValue
	
} // end class
