package DBinterface;

import java.util.ArrayList;

import DAO.DoctorDAO;
import DAO.patientDAO;
import DTO.DoctorDTO;
import DTO.patientDTO;

public class serviceimple implements service {

	DoctorDAO ddao = DoctorDAO.getInstance();
	patientDAO dtao = patientDAO.getInstance();

	@Override
	public void promiss() {
		// �����ϱ� �����ϱ�
		list();
		System.out.println("������ ���ϽŴٸ� ���̵�� ���� ��¥ �Է����ּ���");

		String selid = "aa";
		int selday = 200905;

		patientDTO patientdto = new patientDTO();
		patientdto.setId(selid);
		patientdto.setDay(selday);

		dtao.promiss(selid, selday, 0);
		ddao.updateable(selday);
	}

	@Override
	public ArrayList<DoctorDTO> list() {

		return ddao.selectdoctor();

	}

}
