import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class SRTWriter {

	public void write(Subtitle sub) {
		
		String subName = sub.getSubName();
		int subCount = 1;
		
		try {
			//TODO:SEND FILES TO SAME DIRECTORY AS THE INPUT FILES
			PrintWriter writer = new PrintWriter(subName+".srt", "UTF-8");
			
			for(Section s: sub.getSection()) {
				for(SubSection ss: s.getSubSection()) {
					writer.println(subCount);
					subCount++;
					writer.println(ss.getStart() + " --> " + ss.getEnd());
					writer.println(ss.getText());
					writer.println();
				}
			}
			writer.close();
			System.out.println("Created File ---> " + subName + ".srt");
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
