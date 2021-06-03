package ch08;
 class Employee {//278쪽 4번 문제
	public String name;
	public String grade;
	public Employee() {
		
	}
	public Employee(String name) {
		this.name = name;
	}

}
class Engineer extends Employee{

	private String skillset;
	public String getSkillSet;
	public String getSkillSet() {
		return skillset;
	}
	public void setSkillSet(String skillset) {
		this.skillset = skillset;
	}
}
