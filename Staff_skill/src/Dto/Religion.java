package Dto;

public class Religion {
	private int no;
	private String name;
	
	public Religion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Religion(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "religionDto [no=" + no + ", name=" + name + "]";
	}
	

}
