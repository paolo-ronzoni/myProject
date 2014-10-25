package outputView;

import recommendationSystem.*;
import fileIO.IOMethods;

import java.util.Arrays;

/* This class test the formula sim(a,p) against the recommender systems database u.txt: 100,000 ratings (1-5) from 943 users on 1682 movies.
 */

public class Test_08_ItemBased {

	static String path1 = "DataStore\\u.txt";
	static String splitExpression = "\\s+";
		
			
			
	public static void main(String[] args) {

		String[][] myMatrix = IOMethods.txtMatrix(path1, splitExpression);

		
//---input elements for the formula of userBasedSiamilarity------

// the rectangular matrix of user, items and ratings
int[][] secondMatrix = IOMethods.matrixConversion(myMatrix);
int columnOfUsers = 0; // the users' column in the input matrix 
int firstItem = 86; // the first item used to compute the similarity
int secondItem = 5; // the second item used to compute the similarity
double predictedItemBasedValue;

System.out.printf("This section test the formula sim(a,b), called cosine similarity,\nagainst the recommender systems database u.txt,\n100,000 ratings (1-5) from 943 users on 1682 movies:\n\n");
for(secondItem = 345; secondItem <= 367; secondItem++)
{
	predictedItemBasedValue = ItemBasedNearestNeighbor.cosineSimilarity(secondMatrix, columnOfUsers, firstItem, secondItem);
		System.out.printf("CosineSimilarity (firstItem=%3d,secondItem=%3d):%6.2f\n", firstItem, secondItem, predictedItemBasedValue);
}

System.out.println("\n-----End of computation-----"); // newline


	} // end main
} // end class Test_08_ItemBased
