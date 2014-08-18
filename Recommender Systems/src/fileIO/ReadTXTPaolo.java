package fileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadTXTPaolo {
	static String path1 = "DataStore\\u1.txt";
	public static void main(String[] args) {
	
		
		try {
			File file = new File(path1);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String inputLine;
			String[] splitedString;
			while ((inputLine = bufferedReader.readLine()) != null) {
				
				splitedString = inputLine.split("\\s+");
				System.out.println(splitedString[0]);			
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
	}
	
	/**
	 * @param filePath location of the .txt file
	 * @return number of rows in the .txt file
	 */
	public static int rowCounter(String filePath)
	 {
		 int numRow = 0;
		 File afile = new File(filePath);
		 Scanner inputStream;
		 try 
		 {
			 inputStream = new Scanner(afile);
			 while (inputStream.hasNext())
			    {   
				 inputStream.nextLine();
				 numRow++;
			    }
			 inputStream.close(); 
		 }
		 catch (FileNotFoundException e) 
		 {
			  e.printStackTrace();
			 
		 }
		 
		 return numRow;
	 } // end method rowCounter
}