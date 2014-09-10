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
public double meanAbsoluteErrorUserBased(int[][] inputMatrix, int userColumnNumber, int itemcolumnNumber,  int numOfNearestNeighbor, int userStart, int userEnd) {
double prov = 2.3;
int totalNumOfRating = 0;
//int userSearched = 1;
int itemSearched;
double numerator = 0;
double denominator = 0;

for ( int i = userStart; i <= userEnd; i++) {
itemSearched = 1;
numerator += UserBasedNearestNeighbor.predictionUserBasedValue(inputMatrix, userColumnNumber,  i, itemcolumnNumber, itemSearched, numOfNearestNeighbor);

}// end for


return prov;
}

} // end class AccracyMetrics 
