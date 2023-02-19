import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class bankingSolution {

	public static void main(String[] args) {

		Client bank = new Client();
		
		String fileLocation = "src/Input.txt";
				
		try {
			
			File fileObj = new File(fileLocation);
			Scanner reader = new Scanner(fileObj);
			int lineNumber = 0;
			
			while (reader.hasNextLine())
			{
				String line = reader.nextLine();
				lineNumber++;
				if(!bank.input(line))
				{
					System.out.println("on line: " + lineNumber + " in file " + fileLocation);
				}
			}
			reader.close();
			
		} catch (FileNotFoundException e){
	        System.out.println("An error occurred.");
	        e.printStackTrace();
		}
	}

}
