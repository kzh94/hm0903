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
		// 예약하기 구현하기
		list();
		System.out.println("예약을 원하신다면 아이디와 예약 날짜 입력해주세요");

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
