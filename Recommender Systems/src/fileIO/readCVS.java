package fileIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class readCVS {

    public static void main(String[] args) {
 // .csv comma separated values
 String path1 = "C:\\Users\\Paolo\\workspace\\"
	 + "Recommender Systems\\src\\";
 String path2 = "C:\\Users\\Paolo\\Desktop\\";
 String fileName = path2 + "prova.csv";
 File file = new File(fileName); //ToDo: read about fiel
 
 try {
  Scanner inputStream = new Scanner(file);
  int count = 0;
  int column = 14;
  int sumOfVector = 0;
  
   while (inputStream.hasNext())
    {   
    
//    System.out.println("<" + count + ":" + inputStream.next() + ">");
    String data = inputStream.nextLine();//gets a whole line
//    System.out.println(data);
    String[] values = data.split(",");
//    System.out.println(count + ": " + values[column]);
    System.out.println(data);
//    System.out.println(charCounter(data,','));
    count++;
   }
  
  String prova = "4489,1,2,";
  System.out.println(charCounter(prova, ','));
  
  Integer[] arrayOfcommas = new Integer[charCounter(prova, ',')];
  for (int m = 0, n = 1; n <= prova.length(); m++, n++)
  {
	 

	  	System.out.print(prova.substring(m,n) + "|");
		 
		 
  }
  
  for (int k = 0; k < arrayOfcommas.length; k++)
  {
	  System.out.print(arrayOfcommas[k] + " ");
  }
  
  inputStream.close();
  
 } 
// catch (Exception e) {
//  // TODO Auto-generated catch block
 //  e.getMessage();
// }
 catch (FileNotFoundException e) {
  // TODO Auto-generated catch block
  e.printStackTrace();
 }
 


 
    } //end main
    /**
     * @param aString a alphanumeric string 
     * @param ch a single character 
     * @return the number of ch in the aString
     */
    public static int charCounter(String aString, char ch)
    {
      int count = 0;
      for(int k = 0; k < aString.length(); k++) {
    	if(aString.charAt(k) == ch) {
    		count++;
    	} //end if  	   
      } //end for
      return count;
    } //end charCounter method
    
} // end class readCVS
