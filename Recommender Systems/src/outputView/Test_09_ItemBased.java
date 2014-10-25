package outputView;

import recommendationSystem.*;
import fileIO.IOMethods;

import java.util.Arrays;

/* This class test the formula sim(a,p) against the Table 2.1.  (pag. 19 from book "Recommender Systems An Introduction by Jannach & al.)
 */

public class Test_09_ItemBased {

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
double predictedItemBasedValue;

System.out.printf("This section test the formula 2.7 sim(a,b), called adjusted cosine similarity,\nagainst the Table 2.1.  (pag. 16 from book \"Recommender Systems An Introduction\"\nby Jannach & al.). Where \'a\' is the firstItem and \'b\' is the secondItem:\n\n");
predictedItemBasedValue = ItemBasedNearestNeighbor.adjustedCosineSimilarity(secondMatrix, columnOfUsers, firstItem, secondItem);
	System.out.printf("AdjustedCosineSimilarity (firstItem=%3d,secondItem=%3d):%6.2f\n", firstItem, secondItem, predictedItemBasedValue);

System.out.println("\n-----End of computation-----"); // newline


	} // end main
} // end class Test_09_ItemBased
