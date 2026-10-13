package queueADT;

public class PrintJob {
	String id;
	String doc_name;
	int MAX_MEMBERS = 5;
	String[] members = new String[MAX_MEMBERS];
	String num_pages;
	
	public PrintJob(String newId, String newDocName, String[] newMembers, String newNumPages) {
		id = newId;
		doc_name = newDocName;
		members = newMembers;
		num_pages = newNumPages;
	}
	
	public String toString() {
		return doc_name;
	}
}
