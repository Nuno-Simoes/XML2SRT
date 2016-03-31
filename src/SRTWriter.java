import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class SRTWriter {

	public void write(Subtitle sub, String path) {
		
		int subCount = 1;
		String[] split = path.split(".xml");
		
		try {
			PrintWriter writer = new PrintWriter(split[0]+".srt", "UTF-8");
			
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
			System.out.println("Created File ---> " + sub.getSubName() + ".srt");
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
