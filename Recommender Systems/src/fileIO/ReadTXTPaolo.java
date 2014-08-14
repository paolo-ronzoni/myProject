package fileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTXTPaolo {
	static String path1 = "DataStore\\prova.txt";
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
}