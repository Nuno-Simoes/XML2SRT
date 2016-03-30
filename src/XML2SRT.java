import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


public class XML2SRT {

	public static void main(String[] args){
			//TODO: PARSE AND CONVERT MULTIPLE XML SUBS IN A CERTAIN DIRECTORY
			File inputFile = new File("src/subtitles/4625179.xml");
			XMLParser parser = new XMLParser();
			SRTWriter writer = new SRTWriter();
			try {
				Subtitle sub = parser.parse(inputFile);
				writer.write(sub);
			} catch (ParserConfigurationException | SAXException | IOException e) {
				e.printStackTrace();
			}
	}
		
}