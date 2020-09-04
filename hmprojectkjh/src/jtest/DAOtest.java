package jtest;

import java.util.ArrayList;



import org.junit.Before;
import org.junit.Test;

import DAO.DoctorDAO;
import DAO.patientDAO;
import DTO.DoctorDTO;

public class DAOtest {
	
	DoctorDAO ddao=null;
	patientDAO ptao=null;
	
	@Before 
	public void loading() {
		ddao=DoctorDAO.getInstance();
		ptao=patientDAO.getInstance();
	}
	
	@Test//����Ʈ �̾ƿ��� �׽�Ʈ
	public void selectdoctor() {
		ArrayList<DoctorDTO> list = ddao.selectdoctor();
		for(int i=0; i < list.size();i++) {
			System.out.println("-------------------");
			System.out.println(list.get(i).getNo());
			System.out.println(list.get(i).getDoctor());
			System.out.println(list.get(i).getDay());
			System.out.println(list.get(i).getAble());
		}
	}
	@Test
	 public void updateable() {//������ �Ұ������� �ٲ�� ���� ���� �żҵ�
		ddao.updateable(200905);
	}
	@Test 
	public void promisstest() {
		ptao.promiss("aa", 200904,1);
	}
	
	@Test 
	public void dabletest() {
		ptao.dable();
	}
	
}
