package imageStorage.entity;

public class ShowData extends User{
	private String departmentName;
	private String projectName;
	private String projectPosition;
	private String time;
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	private int year;
	public int getYear() {
		return year;
	}

	public void setYear(int currentYear) {
		int birthYear=Integer.parseInt(this.getUserId().substring(6, 10));
		int year=currentYear-birthYear;
		this.year = year;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectPosition() {
		return projectPosition;
	}
	public void setProjectPosition(String projectPosition) {
		this.projectPosition = projectPosition;
	}
	

}
