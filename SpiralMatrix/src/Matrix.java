import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Matrix {
	
	public String[][] initArray(int rowCount, int colCount, String fileName) throws FileNotFoundException {
		String[][] a = new String[rowCount][colCount];
		File inFile = new File(fileName);
		Scanner in = new Scanner(inFile);
		int lineCount = 0;
		while (in.hasNextLine()) {
			String[] currentLine = in.nextLine().trim().split("\\s+"); 
			for (int i = 0; i < currentLine.length; i++)
				a[lineCount][i] = currentLine[i];
			lineCount++;
		}             
		return a;
	}
	
	public int determineRowCount(String fileName) throws FileNotFoundException {
		File inFile = new File(fileName);
		Scanner in = new Scanner(inFile);
		int lineCount = 0;
		while (in.hasNextLine()) {
			in.nextLine();
			lineCount++;          
		}
		in.close();
		return lineCount;
	}
	
	public int determineColCount(String fileName) throws FileNotFoundException {
		File inFile = new File(fileName);
		Scanner in = new Scanner(inFile);
		int intLength = 0;
		String[] length = in.nextLine().trim().split("\\s+");
		for (int i = 0; i < length.length; i++)
		  intLength++;
		in.close();
		return intLength;
	}
	
	public List<String> spiralPrint(int rowCount, int colCount, String[][] a) {
		int i, k = 0, l = 0;
		List<String> list = new ArrayList<String>();
 
	    /*  k - starting row index
	        m - ending row index
	        l - starting column index
	        n - ending column index
	        i - iterator
	    */
 
	    while (k < rowCount && l < colCount) {
	        /* Print the first row from the remaining rows */
	        for (i = l; i < colCount; ++i) {
	            list.add(a[k][i]);
	        }
	        k++;
	 
	        /* Print the last column from the remaining columns */
	        for (i = k; i < rowCount; ++i) {
	        	list.add(a[i][colCount-1]);
	        }
	        colCount--;
 
	        /* Print the last row from the remaining rows */
	        if ( k < rowCount) {
	            for (i = colCount-1; i >= l; --i) {
	            	list.add(a[rowCount-1][i]);
	            }
	            rowCount--;
	        }
 
	        /* Print the first column from the remaining columns */
	        if (l < colCount) {
	            for (i = rowCount-1; i >= k; --i) {
	            	list.add(a[i][l]);
	            }
	            l++;    
	        }        
	    }
	    return list;
	}
 
	public static void main(String[] args) throws Exception {
	    Matrix m = new Matrix();
	    String fileName = "C:\\a.txt";
	    int rowCount = m.determineRowCount(fileName);
	    int colCount = m.determineColCount(fileName);
	    System.out.println(rowCount);
	    System.out.println(colCount);
	    String[][] a = m.initArray(rowCount, colCount, fileName);
	    System.out.println(m.spiralPrint(rowCount, colCount, a));
	}
}
