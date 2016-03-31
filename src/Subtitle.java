import java.util.ArrayList;
import java.util.List;

public class Subtitle{
	private String subName;
	private List<Section> section = new ArrayList<>(); 
	
	public Subtitle(String name){
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
	private ArrayList<String> lines = new ArrayList<>();
	
	public SubSection(String start) {
		this.start = start;
	}
	
	public void setStart(String start) {
		this.start = start;
	}
	
	public String getStart() {
		return this.start;
	}
	
	public void setEnd(String end) {
		this.end = end;
	}
	
	public String getEnd() {
		return this.end;
	}
	
	public void setLine(String line) {
		this.lines.add(line);
		
	}
	
	public String getText() {
		String text = "";
		
		for(String s: this.lines) {
			text += s + "\t"; 
		}
		return text;
	}
}