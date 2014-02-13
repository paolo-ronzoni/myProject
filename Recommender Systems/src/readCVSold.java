import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class readCVSold {

    public static void main(String[] args) {
 // .csv comma separated values
 String path = "H:\\"; 
 String fileName = path + "data.csv";
 File file = new File(fileName); //ToDo: read about fiel
 
 try {
  Scanner inputStream = new Scanner(file);
  int count = 0;
  int column = 17;
  
   while (inputStream.hasNext())
    {   
    
//    System.out.println("<" + count + ":" + inputStream.next() + ">");
    String data = inputStream.nextLine();//gets a whole line
    System.out.println(data);
//    String[] values = data.split(",");
//    System.out.println(data);
    System.out.println(charCounter(data,','));
    count++;
   }
  
  String prova = "4489,1,2,2,4,5,,2,3,2,2,1,,4,5,5";
  System.out.println(charCounter(prova, '9'));
  
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
    
    public static int charCounter(String aString, char ch){
      int count = 0;
      char theChar = ch; //character to count
      for(int k = 0; k < aString.length(); k++)
      {
    	if(aString.charAt(k) == theChar)
    	{
    		count++;
    	}   	   
      }
      return count;
    }
} // end class readCVS
