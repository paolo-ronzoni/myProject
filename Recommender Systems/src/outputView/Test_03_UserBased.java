package outputView;

import recommendationSystem.*;
import fileIO.IOMethods;
import java.util.Arrays;

/* This class test the formula sim(a,b) against the recommender systems database u.txt: 100,000 ratings (1-5) from 943 users on 1682 movies. 
 */

public class Test_03_UserBased {

	static String path1 = "DataStore\\u.txt";
	static String splitExpression = "\\s+";
		
	public static void main(String[] args) {

		String[][] myMatrix = IOMethods.txtMatrix(path1, splitExpression);

		
//---input elements for the formula of userBasedSiamilarity------

// the rectangular matrix of user, items and ratings
int[][] secondMatrix = IOMethods.matrixConversion(myMatrix);
int columnOfUsers = 0; // the column, in the rectangular input matrix with the users
int firstUser = 301; // the first user to compute the similarity

System.out.printf("This section test the correctness of the  result of the method\n\'userNearestNeighborValue\'  with the results of the book of Recommender Systems\n");
double nearestValue;
for (int secondUser = 1; secondUser <= 301; secondUser++) 
{
	nearestValue = UserBasedNearestNeighbor.userNearestNeighborValue(secondMatrix, columnOfUsers, firstUser, secondUser);
		   System.out.printf("Similarity user %s and %s: %6.2f\n", firstUser, secondUser, nearestValue);
} // end for

	} // end main
} // end class Test_02_UserBased
