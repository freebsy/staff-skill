package Dto;

public class staffandskill {
	private int no;
	private Staff staff;
	private Skill skill;
	public staffandskill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public staffandskill(int no, Staff staff, Skill skill) {
		super();
		this.no = no;
		this.staff = staff;
		this.skill = skill;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	@Override
	public String toString() {
		return "staffandskill [no=" + no + ", staff=" + staff + ", skill=" + skill + "]";
	}

}
