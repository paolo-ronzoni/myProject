package outputView;

import recommendationSystem.*;
import fileIO.IOMethods;

import java.util.Arrays;

/* This class test the formula sim(a,p), adjusted cosine similarity, against the recommender systems database u.txt: 100,000 ratings (1-5) from 943 users on 1682 movies.
 */

public class Test_10_ItemBased {

	static String path1 = "DataStore\\u.txt";
	static String splitExpression = "\\s+";
		
			
			
	public static void main(String[] args) {

		String[][] myMatrix = IOMethods.txtMatrix(path1, splitExpression);

		
//---input elements for the formula of userBasedSiamilarity------

// the rectangular matrix of user, items and ratings
int[][] secondMatrix = IOMethods.matrixConversion(myMatrix);
int columnOfUsers = 0; // the column, in the rectangular input matrix, with the users number
int firstItem = 23; // the first user to compute the similarity
int secondItem = 5;
double predictedItemBasedValue;

System.out.printf("This section test the formula sim(a,b), called cosine similarity,\n against the recommender systems database u.txt,\n 100,000 ratings (1-5) from 943 users on 1682 movies.:\n\n");
for(secondItem = 345; secondItem <= 367; secondItem++)
{
	predictedItemBasedValue = ItemBasedNearestNeighbor.adjustedCosineSimilarity(secondMatrix, columnOfUsers, firstItem, secondItem);
		System.out.printf("AdjustedCosineSimilarity, firstItem=%s,secondItem=%s: %6.2f\n", firstItem, secondItem, predictedItemBasedValue);
}

System.out.println(); // newline


	} // end main
} // end class Test_07_ItemBased
