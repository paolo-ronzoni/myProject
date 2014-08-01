import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
public class ReadCVS {
 
  public static void main(String[] args) {
 
	ReadCVS obj = new ReadCVS();
	obj.run();
 
  }
 
  public void run() {
 
	String csvFile = "C:\\Users\\Paolo\\Desktop\\data.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
 
	try {
 
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
 
		        // use comma as separator
			String[] countryRaw = line.split(cvsSplitBy);
			
			for (int n = 0; n < countryRaw.length; n++) {
				
		        if (countryRaw[n].isEmpty())
		        	countryRaw[n] = null;
						
				}
 
			//System.out.println( country[0] + " " + country[1] + " " + country[12]);
			for (int n = 0; n < countryRaw.length; n++) {
				
			
			  System.out.print(countryRaw[n] + " ");
				
				if ( n % 20 == 0) {
					System.out.println();
				}
			}
 
		}
 
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
 
	//System.out.println("Done");
  }
 
}