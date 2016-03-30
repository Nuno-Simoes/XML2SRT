import java.util.ArrayList;
import java.util.List;

public class Subtitle{
	private String subName;
	private List<Section> section = new ArrayList<>(); 
	
	public Subtitle(String name){
		System.out.println("New Sub: "+ name);
		this.subName = name;
	}
	
	public void setSubName(String id) {
		this.subName = id;
	}
	
	public String getSubName() {
		return this.subName;
	}
	
	public void addSection(String id) {
		section.add(new Section(id));
	}
	
	public Section getSection(int index) {
		return section.get(index);
	}
	
	public List<Section> getSection() {
		return this.section;
	}
}

class Section{
	private String id;
	private List<SubSection> subs = new ArrayList<>();

	public Section(String id) {
		System.out.println("<---------------------------------->");
		System.out.println("<---------------------------------->");
		System.out.println("<---------------------------------->");
		System.out.println("New section: "+ id);
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void addSubsection(String start) {
		subs.add(new SubSection(start));
	}
	
	public SubSection getSubSection(int index) {
		return subs.get(index);
	}
	
	public List<SubSection> getSubSection() {
		return this.subs;
	}
}

class SubSection{
	private String start;
	private String end;
	private ArrayList<String> text = new ArrayList<>();
	
	public SubSection(String start) {
		System.out.println("SubSect Start: "+ start);
		this.start = start;
	}
	
	public void setStart(String start) {
		this.start = start;
	}
	
	public String getStart() {
		return this.start;
	}
	
	public void setEnd(String end) {
		System.out.println("SubSec End: "+ end);
		this.end = end;
	}
	
	public String getEnd() {
		return this.end;
	}
	
	public void setLine(String line) {
		System.out.println("TEXT:: " + line);
		this.text.add(line);
		
	}
	
	public ArrayList<String> getText() {
		return this.text;
	}
}