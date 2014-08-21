package oldStuff;

public class MyClass {

	public static void main(String[] args) {
		 String prova = "4489,1,2,,,,,,adf,";
		  System.out.println(readCVS.charCounter(prova, ','));
		  
		  Integer[] arrayOfcommas = new Integer[readCVS.charCounter(prova, ',')];
		  int index = 0;
		  for (int m = 0, n = 1; n <= prova.length(); m++, n++)
		  {
			  if (prova.substring(m,n).equals(","))
			  {
				  arrayOfcommas[index] = m;
				  index++;
			  }
		  }

       for (Integer values: arrayOfcommas)
    	   System.out.print(values + " ");
		 
	} // end of main
		  
		  
			  
		  
		  

	} // end of class


