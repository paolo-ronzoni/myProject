package recommendationSystem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class MatrixBuilder {

	
	/** 
	 * @param inputMatrix an input matrix of type int
	 * @param columnNumber position of the column where to search
	 * @param elementSearched the integer searched
	 * @return number of integer founded in the column
	 * @author Paolo Ronzoni
	 */
	public static int numberOfElement(int[][] inputMatrix, int columnNumber, int elementSearched) {
		int nRows = inputMatrix.length;
		int numberOfElement = 0;
		
		for (int row = 0; row < nRows; row++)
		{
		    if (inputMatrix[row][columnNumber] == elementSearched) 
		    	numberOfElement++;
		} 			 
		return numberOfElement;
	 } // end method numberOfElement
	
	
	/** 
	 * @param inputMatrix an input matrix of type int
	 * @param columnNumber position of the column where to search
	 * @param elementSearched the integer searched
	 * @return outputMatrix a three column matrix with userID, ItemId, rating
	 * @author Paolo Ronzoni
	 */
	public static int[][] userIDchoices(int[][] inputMatrix, int columnNumber, int elementSearched) {
		int nRows = inputMatrix.length;
		int nRowsUser = numberOfElement(inputMatrix, columnNumber, elementSearched);
		int[][] outputMatrix = new int[nRowsUser][3];
		int userRow = 0;
		for (int row = 0; row < nRows; row++)
		{
		    if (inputMatrix[row][columnNumber] == elementSearched) 
		    {
		    	for (int column = 0; column < 3; column++) {
		    	outputMatrix[userRow][column] = inputMatrix[row][column];
		    	}
		    	userRow++;
		    }
		    
		} 			 
		return outputMatrix;
	 } // end method userIdChoices
	
	
//	/** 
//	 * @param inputMatrix an input matrix of type int
//	 * @param columnNumber position of the column where to search
//	 * @param elementSearched the integer searched
//	 * @return a three column matrix with userID, ItemId, rating
//	 * @author Paolo Ronzoni
//	 */
//	public static int[][] singleUserIDchoices(int[][] inputMatrix, int columnNumber, int elementSearched) {
//		int nRows = inputMatrix.length;
//		int nRowsUser = numberOfElement(inputMatrix, columnNumber, elementSearched);
//		int[][] finalMatrix = new int[nRowsUser][3];
//		int userRow = 0;
//		for (int row = 0; row < nRows; row++)
//		{
//		    if (inputMatrix[row][columnNumber] == elementSearched) 
//		    {
//		    	for (int column = 0; column < 3; column++) {
//		    	finalMatrix[userRow][column] = inputMatrix[row][column];
//		    	}
//		    	userRow++;
//		    }
//		    
//		} 			 
//		return finalMatrix;
//	 } // end method singleUserIdChoices
	
	
	/** 
	 * @param inputMatrix an input matrix of type int
	 * @param columnNumber position of the column where to search
	 * @param firstelementSearched the first user searched
	 * @param secondelementSearched the second user searched
	 * @return a three column matrix with the common choices of the two users
	 * @author Paolo Ronzoni
	 */
	public static int[][] matchIDchoices(int[][] inputMatrix, int columnNumber, int firstElementSearched, int secondElementSearched) {		
		
		int[][] firstUserMatrix = userIDchoices(inputMatrix, columnNumber, firstElementSearched);
		int[][] secondUserMatrix = userIDchoices(inputMatrix, columnNumber, secondElementSearched);
		int firstUserRows = firstUserMatrix.length;
		int secondUserRows = secondUserMatrix.length;
		int itemPosition = 1;
		int[][] outputMatrix = new int[(int)Math.min(firstUserRows, secondUserRows)][3];
		int userRow = 0;
		int outPutRow = 0;
			
		for (int i = 0; i < firstUserRows  ; i++)
		{
			for (int j = 0; j < secondUserRows; j++) 
			{
		    if (firstUserMatrix[i][itemPosition] == secondUserMatrix[j][itemPosition] ) 
			    {
		    	    
			    	outputMatrix[userRow][0] = secondUserMatrix[j][1];
			    	outputMatrix[userRow][1] = firstUserMatrix[i][2];
			    	outputMatrix[userRow][2] = secondUserMatrix[j][2];
			    	if (outputMatrix[userRow][0] != 0) outPutRow++;
			    	userRow++;
			    	
			    }
			}// end inner for
		} // end outer for 	
		
		int[][] finalMatrix = new int[outPutRow][3];
		for (int k = 0; k < outPutRow; k++) {
			for (int column  = 0; column < 3; column++)
			finalMatrix[k][column] = outputMatrix[k][column];
		}
		
		
		return finalMatrix;
	 } // end method matchIdChoices
	
	
	/** 
	 * @param inputMatrix an input matrix of type int
	 * @param columnNumber position of the column where to search
	 * @return finalList an Integer array with all element in a column (users) without duplication
	 * @author Paolo Ronzoni
	 */
	public static int[] findAllUsers(int[][] inputMatrix, int columnNumber) {
		int nRows = inputMatrix.length;
	
		Integer[] firstList = new Integer[nRows];
		for (int row = 0; row < nRows; row++)
		{  
		    firstList[row]= inputMatrix[row][columnNumber];
		}
		Set<Integer> usersSet = new HashSet<> (Arrays.asList(firstList));

		Integer[] secondList = usersSet.toArray(new Integer[0]);  
		int[] finalList = new int[secondList.length];
		for (int k = 0; k < secondList.length; k++) {
			finalList[k] = secondList[k];
		}
			 
		return finalList;
	 } // end method findAllUsers
	
	
	/** 
	 * @param inputMatrix an input matrix of type int
	 * @param columnNumber position of the column where to search
	 * @param elementSearched the integer searched
	 * @return boolean true if there is the item in the column
	 * @author Paolo Ronzoni
	 */
	public static boolean isThereItem(int[][] inputMatrix, int columnNumber, int elementSearched) {
		int nRows = inputMatrix.length;
		boolean result = false;
		for (int row = 0; row < nRows; row++)
		{
		    if (inputMatrix[row][columnNumber] == elementSearched){
		    result = true;
		    break;
		    }
		} 			 
		return result;
	 } // end method userIdChoices
	
	
	/** 
	 * @param inputMatrix an input matrix of type int
	 * @param columnNumber position of the column where to search
	 * @param elementSearched the integer searched
	 * @return boolean true if there is the item in the column
	 * @author Paolo Ronzoni
	 */
	public static int getItem(int[][] inputMatrix, int columnNumber, int elementSearched, int outputColumn) {
		int nRows = inputMatrix.length;
		int itemSearched = 0;
		for (int row = 0; row < nRows; row++)
		{
		    if (inputMatrix[row][columnNumber] == elementSearched){
		    itemSearched = inputMatrix[row][outputColumn];
		    }
		} 			 
		return itemSearched;
	 } // end method userIdChoices
	
	

	/** 
	 * @param inputMatrix an input matrix of type int
	 * @param columnNumber position of the column where to search
	 * @param firstelementSearched the first element searched
	 * @param secondelementSearched the second element searched
	 * @return fianlMatrix a three column matrix userID ratingOfFirstElementSearched ratingOfSecondElementSearched
	 * @author Paolo Ronzoni
	 */
	public static int[][] doubleItemRatingMatrix(int[][] inputMatrix, int columnNumber, int firstElementSearched, int secondElementSearched) {		
		int usersColumn = 0;
		int[] usersArray = findAllUsers(inputMatrix, usersColumn);
		int usersNumber = usersArray.length;
		
		int[][] intermediateMatrix = userIDchoices(inputMatrix, columnNumber, firstElementSearched);
	
		
		for (int row = 0; row < usersNumber; row++) {
			
		}
		
			
//		for (int i = 0; i < firstUserRows  ; i++)
//		{
//			for (int j = 0; j < secondUserRows; j++) 
//			{
//		    if (firstUserMatrix[i][itemPosition] == secondUserMatrix[j][itemPosition] ) 
//			    {
//		    	    
//			    	outputMatrix[userRow][0] = secondUserMatrix[j][1];
//			    	outputMatrix[userRow][1] = firstUserMatrix[i][2];
//			    	outputMatrix[userRow][2] = secondUserMatrix[j][2];
//			    	if (outputMatrix[userRow][0] != 0) outPutRow++;
//			    	userRow++;
//			    	
//			    }
//			}// end inner for
//		} // end outer for 	
		
//		int[][] finalMatrix = new int[outPutRow][3];
//		for (int k = 0; k < outPutRow; k++) {
//			for (int column  = 0; column < 3; column++)
//			finalMatrix[k][column] = outputMatrix[k][column];
//		}
		
		
		return intermediateMatrix;
	 } // end method matchIdChoices
	

} // end class
