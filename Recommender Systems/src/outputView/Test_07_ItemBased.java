package outputView;

import recommendationSystem.*;
import fileIO.IOMethods;

import java.util.Arrays;

/* This class test the formula sim(a,p) against the Table 2.1.  (pag. 19 from book "Recommender Systems An Introduction by Jannach & al.)
 */

public class Test_07_ItemBased {

	static String path1 = "DataStore\\bookDataTab2dot1.txt";
	static String splitExpression = "\\s+";
		
			
			
	public static void main(String[] args) {

		String[][] myMatrix = IOMethods.txtMatrix(path1, splitExpression);

		
//---input elements for the formula of userBasedSiamilarity------

// the rectangular matrix of user, items and ratings
int[][] secondMatrix = IOMethods.matrixConversion(myMatrix);
int columnOfUsers = 0; // the column, in the rectangular input matrix, with the users number
int firstItem = 1; // the first user to compute the similarity
int secondItem = 5;
int itemColumnNumber = 1;
int itemSearched = 5;
int numOfNearestNeighbor = 2;
double predictedItemBasedValue;

System.out.printf("This section test the formula sim(a,b) against the Table 2.1.  (pag. 16\n from book \"Recommender Systems An Introduction\" by Jannach & al.)\nWhere \'a\' is the firstItem and \'b\' is the secondItem:\n");
predictedItemBasedValue = ItemBasedNearestNeighbor.cosineSimilarity(secondMatrix, columnOfUsers, firstItem, secondItem);
	System.out.printf("CosineSimilarity where the firstItem is %s and the secondItem is %s\n : %6.2f\n", firstItem, secondItem, predictedItemBasedValue);

System.out.println(); // newline


	} // end main
} // end class Test_07_ItemBased
