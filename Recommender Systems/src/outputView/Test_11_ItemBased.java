package outputView;

import recommendationSystem.*;
import fileIO.IOMethods;

import java.util.Arrays;

/* This class test the formula pred(a,p) against the Table 2.1.  (pag. 20 from book "Recommender Systems An Introduction by Jannach & al.)
 */

public class Test_11_ItemBased {

	static String path1 = "DataStore\\bookDataTab2dot1.txt";
	static String splitExpression = "\\s+";
		
			
			
	public static void main(String[] args) {

		String[][] myMatrix = IOMethods.txtMatrix(path1, splitExpression);

		
//---input elements for the formula of userBasedSiamilarity------

// the rectangular matrix of user, items and ratings
int[][] secondMatrix = IOMethods.matrixConversion(myMatrix);
int columnOfUsers = 0; // the column, in the rectangular input matrix, with the users number
int firstUser = 1; // the first user to compute the similarity
int secondUser = 2;
int itemColumnNumber = 1;
int itemSearched = 5;
int numOfNearestNeighbor = 2;
double predictedUserBasedValue;

System.out.printf("This section test the formula pred(a,p) against the Table 2.1.  (pag. 20\nfrom book \"Recommender Systems An Introduction\" by Jannach & al.)\nWhere \'a\' is the user, \'p\' is the item searched and numOfNearestNeighbor\nare the number of rating to take into account:\n\n");
predictedUserBasedValue = ItemBasedNearestNeighbor.predictionItemBasedValue(secondMatrix, columnOfUsers, firstUser, itemColumnNumber, itemSearched, numOfNearestNeighbor);
	System.out.printf("PredictionItemBasedvalue (user=%3d,item=%3d,numOfRating=%s):%6.2f\n", firstUser, itemSearched, numOfNearestNeighbor, predictedUserBasedValue);

	System.out.println("\n-----End of computation-----"); // newline


	} // end main
} // end class Test_11_UserBased
