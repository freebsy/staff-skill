package Dto;

public class Skill {
	private int no;
	private String name;
	
	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Skill(int no, String name) {
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
		return "skillDto [no=" + no + ", name=" + name + "]";
	}
	

}
