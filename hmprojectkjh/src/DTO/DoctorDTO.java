package DTO;

public class DoctorDTO {
	private int no; 
	private int day;
	private String doctor; 
	private String able;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getAble() {
		return able;
	}
	public void setAble(String able) {
		this.able = able;
	}
	public void getSys() {
		System.out.println("번호 "+no);
		System.out.println("의사이름 "+doctor);
		System.out.println("가능유무 "+able);
		System.out.println("가능날짜 "+day);
	
		System.out.println();
}}
