package javaOOP;

public class Topic_01_Class_Object_Student {
	private int studentID;
	private String studentName;
	private Float knowlegePoint;
	private Float practicePoint;

	private int getStudentID() {
		return studentID;
	}

	private void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	private String getStudentName() {
		return studentName;
	}

	private void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	private Float getKnowlegePoint() {
		return knowlegePoint;
	}

	private void setKnowlegePoint(Float knowlegePoint) {
		this.knowlegePoint = knowlegePoint;
	}

	private Float getPracticePoint() {
		return practicePoint;
	}

	private void setPracticePoint(Float practicePoint) {
		this.practicePoint = practicePoint;
	}

	private Float getAveragePoint() {
		return (this.knowlegePoint + this.practicePoint * 2) / 3;

	}

	private void showStudentInfor() {
		System.out.println("************************************");
		System.out.println("Student ID =" + getStudentID());
		System.out.println("Student ID =" + getStudentName());
		System.out.println("Student ID =" + getKnowlegePoint());
		System.out.println("Student ID =" + getPracticePoint());
		System.out.println("Student ID =" + getAveragePoint());
		System.out.println("************************************");
	}

	public static void main(String[] args) {
		Topic_01_Class_Object_Student firstStudent = new Topic_01_Class_Object_Student();
		firstStudent.setStudentID(20025206);
		firstStudent.setStudentName("John Terry");
		firstStudent.setKnowlegePoint(8.0f);
		firstStudent.setPracticePoint(7.8f);
		firstStudent.showStudentInfor();

		Topic_01_Class_Object_Student secondStudent = new Topic_01_Class_Object_Student();
		firstStudent.setStudentID(20025207);
		firstStudent.setStudentName("John Deep");
		firstStudent.setKnowlegePoint(9.0f);
		firstStudent.setPracticePoint(8.8f);
		firstStudent.showStudentInfor();

	}

}
