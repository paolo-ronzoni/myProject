package outputView;

import recommendationSystem.*;
import fileIO.IOMethods;
import java.util.Arrays;

/* This class test the formula sim(a,b) against the Table 2.1.  (pag. 14 from book "Recommender Systems An Introduction by Jannach & al.)
 */

public class Test_02_UserBased {

	static String path1 = "DataStore\\bookDataTab2dot1.txt";
	static String splitExpression = "\\s+";
		
			
			
	public static void main(String[] args) {

		String[][] myMatrix = IOMethods.txtMatrix(path1, splitExpression);

		
//---input elements for the formula of userBasedSiamilarity------

// the rectangular matrix of user, items and ratings
int[][] secondMatrix = IOMethods.matrixConversion(myMatrix);
int columnOfUsers = 0; // the column, in the rectangular input matrix with the users
int firstUser = 1; // the first user to compute the similarity

System.out.printf("This section test the correctness of the  result of the method\n\'userNearestNeighborValue\'  with the results of the book of Recommender Systems\n");
double nearestValue;
for (int secondUser = 2; secondUser <= 5; secondUser++) 
{
	nearestValue = UserBasedNearestNeighbor.userNearestNeighborValue(secondMatrix, columnOfUsers, 1, secondUser);
		   System.out.printf("Similarity user 1 and %s: %6.2f\n", secondUser,nearestValue);
} // end for

	} // end main
} // end class Test_02_UserBased
