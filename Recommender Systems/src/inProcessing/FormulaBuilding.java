package inProcessing;
import java.util.ArrayList;
import java.util.List;

public class FormulaBuilding {
         
     public static void main(String[] args) {
        		
         
        ArrayList<Integer> s = new ArrayList<>();
         
        s.add(4);
        s.add(56);
       
        Integer[] integerArray = s.toArray(new Integer[0]);
        
       
      for (int i=0;i <s.size(); i++) 
      {
    	  System.out.println(integerArray[i]);
      }

       
     } // end main

} // end Class FormulaBuilding
