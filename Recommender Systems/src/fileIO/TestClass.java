package fileIO;

public class TestClass {

	public static void main(String[] args) {
		
		int numRows = ReadTXTPaolo.rowCounter(ReadTXTPaolo.path1);
		System.out.println("Stampa numero di righe: " + numRows);

	}

}
