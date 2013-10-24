package __0x277F.io.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author 0x277F
 * Simplifies the use of a File object
 *
 */
public class BetterFile extends File implements Serializable {
public BetterFile(String arg0) {
		super(arg0);
	}
/**
 * 
 * @param arg0
 * @param arg1
 * See java.io.File
 */
public BetterFile(String arg0, String arg1){
	super(arg0, arg1);
}
/**
 * 
 * @param arg0
 * See java.io.File
 */
public BetterFile(URI arg0){
	super(arg0);
}
/**
 * 
 * @param arg0
 * @param arg1
 * See java.io.File
 */
public BetterFile(BetterFile arg0, String arg1){
	super(arg0, arg1);
}
private static final long serialVersionUID = 1L;
/**
 * 
 * @return Lines contained within file.
 * @throws IOException
 */
public int getLines() throws IOException {
    FileReader readfile0 = new FileReader(this);
    BufferedReader readfile = new BufferedReader(readfile0);
    @SuppressWarnings("unused")
    String aLine;
    int linecount = 0;
    while ((aLine = readfile.readLine()) != null) {
        linecount++;
    }
    readfile.close();
    readfile0.close();
    return linecount;
}
/**
 * 
 * @return A java.util.List\<String\> that contains the contents of file.
 * @throws IOException
 */
public List<String> read()
        throws IOException {
    FileReader readfile0 = new FileReader(this);
    BufferedReader readfile = new BufferedReader(readfile0);
    List<String> filedata1 = new ArrayList<String>(getLines());
    for (int i = 0; i < getLines(); i++) {
        filedata1.add(readfile.readLine());
    }
    readfile.close();
    readfile0.close();
    return filedata1;
}
/**
 * 
 * @param data Data to append to file.
 * @throws IOException
 * Appends data to the end of file.
 */
public void append(List<String> data) throws IOException{
	fileWrite(data, true);
}
/**
 * 
 * @param data Data to set the file to
 * @throws IOException
 * Makes the contents of the file equal to the List\<String\> Object data.
 */
public void set(List<String> data) throws IOException{
	fileWrite(data, false);
}
/**
 * 
 * @param filewritedata
 * @param appendvalue
 * @throws IOException
 * Back-end for writing to files. 
 */
private void fileWrite(List<String> filewritedata,
        boolean appendvalue) throws IOException {
    FileWriter writefile0 = new FileWriter(this, appendvalue);
    PrintWriter writefile = new PrintWriter(writefile0);
    for(String s : filewritedata) writefile.printf("%s" + "%n", s);
    writefile.close();
}


}
