import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class XML2SRT {

	public static void main(String[] args){

		try {	
			File inputFile = new File("src/subtitles/4625179.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			Subtitle sub = new Subtitle(doc.getDocumentElement().getAttribute("id"));
			
			NodeList nList = doc.getElementsByTagName("s");
			
			for(int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					sub.addSection(eElement.getAttribute("id"));
					
					int currentSS = 0;
					boolean start = true;
					Section sec = sub.getSection(temp);
				
					
					for(int i = 0; i < eElement.getChildNodes().getLength(); i++) {
						
						Node child = eElement.getChildNodes().item(i);
						
						if(child.getNodeName().equals("time") && start) {
							sec.addSubsection(child.getAttributes()
									.getNamedItem("value").getNodeValue());
							start = false;
						} else {
							if(child.getNodeName().equals("time") && !start) {
								sec.getSubSection(currentSS).setEnd(child.getAttributes()
										.getNamedItem("value").getNodeValue());
								start = true;
								currentSS++;
							}
						}
						
						if(child.getNodeName().equals("w"))
							sec.getSubSection(currentSS).setLine(child.getTextContent());			
					}							
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}