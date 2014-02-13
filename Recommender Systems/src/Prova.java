/**
 * 
 */

/**
 * @author Paolo
 *
 */
public class Prova {

	/* Questo e' un commento */
	public static void main(String[] args) {
		String[] values = {"11", "", "34", "22", ""};
		
		for (int k = 0; k < values.length; k++) {
			System.out.print(values[k] + ", ");
		}
		System.out.println();
		
		Object[] valuesInt = new Object[5];
		for (int n = 0; n < values.length; n++) 
		{
			if( values[n] != "") 
			{
				valuesInt[n] = Integer.parseInt(values[n]);
			} 
			else 
			{
				valuesInt[n] = null;
			}
			
		}// end for
		
		Object[] superArray1 = {12.23, "Paolo", null, 23};
		Object[] superArray2 = {1.0, "Paolo", null, 4};
		
		String doubleCast = "double";
		double val1 = (double) superArray1[0];
		double val2 = (double) superArray2[0];

		System.out.println(val1 + val2);
		

	}

}// end calss
