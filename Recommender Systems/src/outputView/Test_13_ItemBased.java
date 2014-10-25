package outputView;

import recommendationSystem.*;
import fileIO.IOMethods;

import java.util.Arrays;

/* This class test the formula pred(a,p) against the recommender systems database u1.txt: 20,000 ratings (1-5) from 943 users on 1682 movies.
 */

public class Test_13_ItemBased {

	static String path1 = "DataStore\\u1.txt";
	static String splitExpression = "\\s+";
		
			
			
	public static void main(String[] args) {

		String[][] myMatrix = IOMethods.txtMatrix(path1, splitExpression);

		
//---input elements for the formula of userBasedSiamilarity------

// the rectangular matrix of user, items and ratings
int[][] secondMatrix = IOMethods.matrixConversion(myMatrix);
int columnOfUsers = 0; // the column, in the rectangular input matrix, with the users number
int firstUser = 1; // the first user to compute the similarity
int itemColumnNumber = 1;
int itemSearched = 5;
int numOfNearestNeighbor = 2;
double predictedItemBasedValue;

System.out.printf("This section test the formula pred(a,p) against the database u1.txt\nWhen the item searched change but  the user searched and the\nnumOfNearestNeighbor are constant:\n\n");
for( itemSearched = 1; itemSearched <= 10; itemSearched++) 
{
	predictedItemBasedValue = ItemBasedNearestNeighbor.predictionItemBasedValue(secondMatrix, columnOfUsers, firstUser, itemColumnNumber, itemSearched, numOfNearestNeighbor);
		System.out.printf("PredictionItemValue (user=%3d,item=%3d,numOfRating=%s):%6.2f\n", firstUser, itemSearched, numOfNearestNeighbor, predictedItemBasedValue);
}
System.out.println("\n-----End of computation-----"); // newline

	} // end main
} // end class Test_13_UserBased
