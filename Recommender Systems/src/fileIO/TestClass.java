package fileIO;

public class TestClass {

	public static void main(String[] args) {
		
		int numRows = ReadTXTPaolo.rowCounter(ReadTXTPaolo.path1);
		int numColumns = ReadTXTPaolo.columnCounter(ReadTXTPaolo.path1, "\\s+");
		String[][] matrice = ReadTXTPaolo.txtMatrix(ReadTXTPaolo.path1, 6, 4);
		System.out.println("Stampa numero di righe: " + numRows);
		System.out.println("Stampa numero di colonne: " + numColumns);
		
		for (int i = 0; i < numRows; i++)  {
			for (int j = 0; j < numColumns; j++)
			{
				System.out.print(matrice[i][j] + " ");
			}
			System.out.println();
		}
			
	}

}
