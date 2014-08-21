package oldStuff;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CvsTransform {

	 public static void main(String[] args) {
		 // .csv comma separated values
		 String path = "C:\\Users\\Pat\\workspace\\"
	 			 + "Recommender Systems\\src\\"; 
		 String fileName = path + "data.csv";
		 File file = new File(fileName); //ToDo: read about fiel
		 
		 try {
		  Scanner inputStream = new Scanner(file);
		  int count = 0;
		  int column = 17;
		  
		   while (inputStream.hasNext())
		    {   
		    
//		    System.out.println("<" + count + ":" + inputStream.next() + ">");
		    String data = inputStream.nextLine();//gets a whole line
		    System.out.println(data);
		    String[] values = data.split(",");
		    for (int k = 0; k < values.length; k++)
		    {
		    		System.out.print(values[k] + " ");
		    }
		    System.out.println();
		    System.out.println(readCVSold.charCounter(data,','));
		    count++;
		   }
		  
		  String prova = "4489,1,2,2,4,5,,2,3,2,2,1,,4,5,5";
		  System.out.println(readCVSold.charCounter(prova, '9'));
		  int numRow = CvsAnalyser.rowCounter(fileName);
		  int columns = CvsAnalyser.columnCounter(fileName);
		  System.out.println("Numero di righe: " + numRow);
		  System.out.println("Numero di colonne: " + columns);
		  
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
		    
	 
	 
} // end class CvsTransform
