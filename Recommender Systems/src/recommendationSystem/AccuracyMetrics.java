package recommendationSystem;

public class AccuracyMetrics {
	

	/**
	* @param inputMatrix an input matrix of type int with columns for users, products and ratings
	* @param usercolumnNumber the position of the column where to search the user
	* @param itemcolumnNumber the position of the column where to search the item
	* @param numOfNearestNeighbor the number of similarity to use to calculate the predictionUserBasedValue
	* @param userStart the first user where to start the computation of Mean Absolute Error
	* @param userEnd the last user used in the computation of Mean Absolute Error
	* @return double the weighted average of the differences between the actual scores and the predicted scores
	* @author Paolo Ronzoni
	*/	
public static double meanAbsoluteErrorUserBasedOneUser(int[][] inputMatrix, int userColumnNumber, int userSearched, int itemColumnNumber,  int numOfNearestNeighbor) {

	// a three column matrix which corresponds to the userSearched with userID, ItemId, rating
	int[][] userMatrix = MatrixBuilder.userIDchoices(inputMatrix, userColumnNumber, userSearched);

	int totalNumOfRating = userMatrix.length;
	int ratingColumnNumber = 2;
	double numerator = 0;

	for ( int row = 0; row <totalNumOfRating; row++) {
	numerator += Math.abs(UserBasedNearestNeighbor.predictionUserBasedValue(inputMatrix, userColumnNumber,  userSearched, itemColumnNumber, userMatrix[row][itemColumnNumber], numOfNearestNeighbor) - userMatrix[row][ratingColumnNumber] );


	}// end for meanAbsoluteErrorUserBasedOneUser

return numerator / totalNumOfRating;
} // end method meanAbsoluteErrorUserBasedOneUser

/**
* @param inputMatrix an input matrix of type int with columns for users, products and ratings
* @param usercolumnNumber the position of the column where to search the user
* @param itemcolumnNumber the position of the column where to search the item
* @param numOfNearestNeighbor the number of similarity to use to calculate the predictionUserBasedValue
* @param userStart the first user where to start the computation of Mean Absolute Error
* @param userEnd the last user used in the computation of Mean Absolute Error
* @return double the weighted average of the differences between the actual scores and the predicted scores normalized dividing by (maxRating - minRating)
* @author Paolo Ronzoni
*/	
public static double normalizedMeanAbsoluteErrorUserBasedOneUser(int[][] inputMatrix, int userColumnNumber, int userSearched, int itemColumnNumber,  int numOfNearestNeighbor) {

// a three column matrix which corresponds to the userSearched with userID, ItemId, rating
int[][] userMatrix = MatrixBuilder.userIDchoices(inputMatrix, userColumnNumber, userSearched);
// the column of the ratings


int totalNumOfRating = userMatrix.length;
int ratingColumnNumber = 2;
double numerator = 0;

for ( int row = 0; row <totalNumOfRating; row++) 
	{
		numerator += Math.abs(UserBasedNearestNeighbor.predictionUserBasedValue(inputMatrix, userColumnNumber,  	userSearched, itemColumnNumber, userMatrix[row][itemColumnNumber], numOfNearestNeighbor) - 	userMatrix[row][ratingColumnNumber] );
	}// end for meanAbsoluteErrorUserBasedOneUser
	
// the column of rating the rating
double[] ratingColumn = MatrixBuilder.columnExtractor(userMatrix, ratingColumnNumber);
double rMax = StatAndMathTools.maxValue(ratingColumn);
double rMin = StatAndMathTools.minValue(ratingColumn);

return (numerator / totalNumOfRating)/(rMax - rMin);
} // end method normalizedMeanAbsoluteErrorUserBasedOneUser


/**
* @param inputMatrix an input matrix of type int with columns for users, products and ratings
* @param usercolumnNumber the position of the column where to search the user
* @param itemcolumnNumber the position of the column where to search the item
* @param numOfNearestNeighbor the number of similarity to use to calculate the predictionUserBasedValue
* @param userStart the first user where to start the computation of Mean Absolute Error
* @param userEnd the last user used in the computation of Mean Absolute Error
* @return double the root weighted average of the squares between the difference among actual scores and the predicted scores
* @author Paolo Ronzoni
*/	
public static double rootMeanSquaredErrorUserBasedOneUser(int[][] inputMatrix, int userColumnNumber, int userSearched, int itemColumnNumber,  int numOfNearestNeighbor) {

// a three column matrix which corresponds to the userSearched with userID, ItemId, rating
int[][] userMatrix = MatrixBuilder.userIDchoices(inputMatrix, userColumnNumber, userSearched);

int totalNumOfRating = userMatrix.length;
int ratingColumnNumber = 2;
double numerator = 0;

for ( int row = 0; row <totalNumOfRating; row++) {
numerator += Math.pow((UserBasedNearestNeighbor.predictionUserBasedValue(inputMatrix, userColumnNumber,  userSearched, itemColumnNumber, userMatrix[row][itemColumnNumber], numOfNearestNeighbor) - userMatrix[row][ratingColumnNumber]), 2);


}// end for rootMeanSquaredErrorUserBasedOneUser

return Math.sqrt(numerator / totalNumOfRating);
} // end method rootMeanSquaredErrorUserBasedOneUser



} // end class AccracyMetrics 
