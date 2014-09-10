package recommendationSystem;

public class AccuracyMetrics {
	

/** 
 * @param inputMatrix an input matrix of type int  with columns for users, products and ratings
 * @param usercolumnNumber the position of the column where to search the user
 * @param itemcolumnNumber the position of the column where to search the item
 * @param numOfNearestNeighbor the number of similarity to use to calculate the predictionUserBasedValue
 * @param userStart the first user where to start the computation of Mean Absolute Error 
 * @param userEnd the last user used in the computation of Mean Absolute Error
 * @return double the weighted average of the differences between the actual scores and the predicted scores
 * @author Paolo Ronzoni
 */	
public double meanAbsoluteErrorUserBased(int[][] inputMatrix, int userColumnNumber, int userSearched, int itemColumnNumber,  int numOfNearestNeighbor, int userStart, int userEnd) {

// a three column matrix which corresponds to the userSearched with userID, ItemId, rating
int[][] userMatrix = MatrixBuilder.userIDchoices(inputMatrix, userColumnNumber, userSearched);

int totalNumOfRating = userMatrix.length;
int ratingColumnNumber = 2;
double numerator = 0;

for ( int row = 0; row <totalNumOfRating; row++) {
numerator += Math.abs(UserBasedNearestNeighbor.predictionUserBasedValue(inputMatrix, userColumnNumber,  userSearched, itemColumnNumber, userMatrix[row][itemColumnNumber], numOfNearestNeighbor) - userMatrix[row][ratingColumnNumber] );


}// end for


return numerator / totalNumOfRating;
}

} // end class AccracyMetrics 
