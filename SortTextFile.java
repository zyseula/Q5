import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.text.Normalizer;
import java.time.LocalDateTime;
import java.util.Scanner;
public class SortTextFile {
  
	String[] name;
	public  SortTextFile() {
		// TODO Auto-generated method stub
		Scanner inputStream = null;
		try{
			inputStream = new Scanner(new FileInputStream(new File ("ds17s-asg2-data.txt")));//ds17s-asg2-data
		}
		catch(FileNotFoundException e){
			System.out.println("File was not found or could not be opened.");
			System.exit(0);
		}
		
		int number = 0;
		int index = 0;
		while (inputStream.hasNextLine()) {
		    String line = inputStream.nextLine(); 
		    number++;
		}
		inputStream.close();
		name = new String[number];
		
		Scanner inputStream_1 = null;
		
		try{
			inputStream_1 = new Scanner(new FileInputStream("ds17s-asg2-data.txt"));//ds17s-asg2-data
		}
		catch(FileNotFoundException e){
			System.out.println("File was not found or could not be opened.");
			System.exit(0);
		}
		while (inputStream_1.hasNextLine()) {
			String temp_String = inputStream_1.nextLine().trim();
			byte[] utf8Bytes;
			try {
				utf8Bytes = temp_String.getBytes("UTF-8");
				String temp_String_Normalize = new String(utf8Bytes, "UTF-8");
				temp_String_Normalize = Normalizer.normalize(temp_String_Normalize, Normalizer.Form.NFD);
				temp_String_Normalize = temp_String_Normalize.replaceAll("[^\\p{ASCII}]", "");
				name[index] = temp_String_Normalize;
				index++;
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		inputStream_1.close();
		SelectionSort(name);	
	}
	private void SelectionSort(String[] name){
			for(int i=0;i<name.length;i++){
				for(int j=i+1;j<name.length;j++){
					if(name[i].compareToIgnoreCase(name[j])>0){
						String temp = name[i];
						name[i] = name[j];
						name[j] = temp;
				}
			}	
		}
	}
	public void print(){
		for(int i = 0; i< name.length;i++)
			System.out.println(name[i]);
	}
}



