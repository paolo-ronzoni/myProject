package inProcessing;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class FormulaBuilding {
         
     public static void main(String[] args) {
        		
         
    	 double[][] a = {{30.4,	4,	9,	20}, 
    			 	     {13, 45, 67,	81}, 
    			 	     {21, 82, 11}};

    	 double[] result = columnExtractor(a, 3);
    	 
    	 for (double element: result)
    		 System.out.println(element);
    	
        
       
//      for (int i=0;i <s.size(); i++) 
//      {
//    	  System.out.println(integerArray[i]);
//      }

       
     } // end main
     
     /** 
 	 * @param inputMatrix an input matrix of type int
 	 * @param columnPosition position of the column where to search
 	 * @return columnExtract an array of type double  with all element of the selected column 
 	 * @author Paolo Ronzoni
 	 */
 	public static double[] columnExtractor(int[][] inputMatrix, int columnPosition) {
 		int nRows = inputMatrix.length;
 	
 		double[] columnExtract = new double[nRows];
 		for (int row = 0; row < nRows; row++)
 		{  
 		    columnExtract[row]= inputMatrix[row][columnPosition];
 		}	 
 		return columnExtract;
 	 } // end method columnExtractor
 	
 	/** 
 	 * @param inputMatrix an input matrix of type double
 	 * @param columnPosition position of the column where to search
 	 * @return columnExtract an array of type double  with all element of the selected column 
 	 * @author Paolo Ronzoni
 	 */
 	public static double[] columnExtractor(double[][] inputMatrix, int columnPosition) {
 		int nRows = inputMatrix.length;
 	
 		double[] columnExtract = new double[nRows];
 		for (int row = 0; row < nRows; row++)
 		{  
 		    columnExtract[row]= inputMatrix[row][columnPosition];
 		}		 
 		return columnExtract;
 	 } // end method columnExtractor
 	
 	
 	
} // end Class FormulaBuilding
