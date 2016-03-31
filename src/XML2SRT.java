import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;


public class XML2SRT {
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		
		System.out.println("To exit type exit");
		System.out.println("Enter the directory where the file is:");
		
		try {
			while((input=br.readLine())!=null) {
				if(input.equals("exit"))
					return;
				try {
					Files.walk(Paths.get(input)).forEach(filePath -> {
						if (Files.isRegularFile(filePath) && filePath.toString().endsWith(".xml")) {
							File inputFile = new File(filePath.toString());
							XMLParser parser = new XMLParser();
							SRTWriter writer = new SRTWriter();
							Subtitle sub;
							try {
								sub = parser.parse(inputFile);
								if(sub != null)
									writer.write(sub, filePath.toString());
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} catch (IOException e) {
					System.out.println("No such file or directory");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
