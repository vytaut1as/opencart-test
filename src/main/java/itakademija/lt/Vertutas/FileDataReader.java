package itakademija.lt.Vertutas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataReader {
	static String fileName;
	
	
	public FileDataReader(String fileName) {
		super();
		this.fileName = fileName;
	}


	public List<String> getTestData() throws IOException{
		//local variables
		List<String> records = new ArrayList<String>();
		String record;
		
		//openfile reading
		BufferedReader file = new BufferedReader(new FileReader(fileName));
		
		//Read each line and add it to the list
		while ((record = file.readLine()) != null){
			records.add(record);
		}
		file.close();
		
		return records;
	}

}
