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
		System.out.println("��ȣ "+no);
		System.out.println("�ǻ��̸� "+doctor);
		System.out.println("�������� "+able);
		System.out.println("���ɳ�¥ "+day);
	
		System.out.println();
}}
