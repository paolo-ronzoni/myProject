package outputView;

import recommendationSystem.*;
import fileIO.IOMethods;

import java.util.Arrays;

/* This class test the formula pred(a,p) against the Table 2.1.  (pag. 16 from book "Recommender Systems An Introduction by Jannach & al.)
 */

public class Test_04_UserBased {

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

System.out.printf("This section test the formula pred(a,p) against the Table 2.1.  (pag. 16\n from book \"Recommender Systems An Introduction\" by Jannach & al.)\nWhere \'a\' is the user, \'p\' is the item searched and numOfNearestNeighbor\nare the number of rating to take into account:\n");
predictedUserBasedValue = UserBasedNearestNeighbor.predictionUserBasedValue(secondMatrix, columnOfUsers, firstUser, itemColumnNumber, itemSearched, numOfNearestNeighbor);
	System.out.printf("PredictionUserBasedvalue where the user is %s the item searched is %s\n and the neighbor's rating taken into accounts are %s: %6.2f\n", firstUser, itemSearched, numOfNearestNeighbor, predictedUserBasedValue);

System.out.println(); // newline


	} // end main
} // end class Test_02_UserBased
