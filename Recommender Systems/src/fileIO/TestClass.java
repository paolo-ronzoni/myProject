package fileIO;

public class TestClass {

	public static void main(String[] args) {
		
		int numRows = ReadTXTPaolo.rowCounter(ReadTXTPaolo.path1);
		int numColumns = ReadTXTPaolo.columnCounter(ReadTXTPaolo.path1);
		String[][] matrice = ReadTXTPaolo.txtMatrix(ReadTXTPaolo.path1, 6, 4);
		System.out.println("Stampa numero di righe: " + numRows);
		System.out.println("Stampa numero di colonne: " + numColumns);
		
		for (String[] array: matrice)  {
			for (String element: array)
				System.out.print(element + " ");
		}
			
	}

}
