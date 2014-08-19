package fileIO;

public class TestClass {

	public static void main(String[] args) {
		
		int numRows = ReadTXTPaolo.rowCounter(ReadTXTPaolo.path1);
		int numColumns = ReadTXTPaolo.columnCounter(ReadTXTPaolo.path1, "\\s+");
		String[][] matrice = ReadTXTPaolo.txtMatrix(ReadTXTPaolo.path1, "\\s+");
		System.out.println("Stampa numero di righe: " + numRows);
		System.out.println("Stampa numero di colonne: " + numColumns);
		
		int numColumnsBis = ReadTXTPaolo.columnCounter("DataStore\\uitem.txt", "\\|+");
		System.out.println("numero di uitem ugenre: " + numColumnsBis);
		
		for (int i = 0; i < numRows; i++)  {
			System.out.print((i + 1) + ": ");
			for (int j = 0; j < numColumns; j++)
			{
				System.out.print(matrice[i][j] + " ");
			}
			System.out.println();
		}
			
	}

}
