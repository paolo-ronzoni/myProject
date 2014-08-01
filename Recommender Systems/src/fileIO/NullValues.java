package fileIO;

public class NullValues {

	public static void main(String[] args) {
		Integer[] intArray = {2, null, 3, 7};
		String[] stringArray = {"ss", null, "paolo", "la"};
		
		for (Integer value: intArray)
		{
				System.out.print(value + " ");
		}
		System.out.println();
		for (String value: stringArray)
		{
				System.out.print(value + " ");
		}
		System.out.println();
		if (stringArray[1] == null) {
			System.out.println("Successo");
		}
		

	} // end main

} // end class
