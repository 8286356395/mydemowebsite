package library.admin.bean;

public class IssueBook {
	 
	private int issueid;
	private int bookid;
	private String bookname;
	private int userid;
	private String username;
	private int period;
	
	private String  issuedate;
	private String  returndate;
	public IssueBook(int issueid, int bookid, String bookname, int userid, String username, int period,
			String issuedate, String returndate) {
		super();
		this.issueid = issueid;
		this.bookid = bookid;
		this.bookname = bookname;
		this.userid = userid;
		this.username = username;
		this.period = period;
		this.issuedate = issuedate;
		this.returndate = returndate;
	}
	public IssueBook(int bookid, String bookname, int userid, String username, int period, String issuedate) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.userid = userid;
		this.username = username;
		this.period = period;
		this.issuedate = issuedate;
	}
	public IssueBook() {
		super();
	}
	public int getIssueid() {
		return issueid;
	}
	public void setIssueid(int issueid) {
		this.issueid = issueid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public String getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	

	
	

}
