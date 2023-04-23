package Model;

public class Email {

	private String From;
	private String Subject;
	private String Content;
	public Email(String From, String Subject, String Content) {
		super();
		this.From = From;
		this.Subject = Subject;
		this.Content = Content;
	}
	public String getFrom() {
		return From;
	}
	public void setFrom(String from) {
		this.From = from;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String Subject) {
		this.Subject = Subject;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String Content) {
		this.Content = Content;
	}
	
	
	
}
