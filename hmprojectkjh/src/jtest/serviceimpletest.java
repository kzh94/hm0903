package jtest;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import DBinterface.serviceimple;
import DTO.DoctorDTO;

public class serviceimpletest {
	serviceimple serv = null;

	@Before
	public void loading() {
		serv = new serviceimple();

	}

	@Test
	public void listtest() {
		ArrayList<DoctorDTO> testlist = serv.list();
		for (int i = 0; i < testlist.size(); i++) {
			testlist.get(i).getSys();
		}

	}

}
