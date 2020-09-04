package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.DoctorDTO;

public class patientDAO {

	private Connection conn = null; // oracle 접속하기 위한 연결 컨넥션
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String id = "system";
	private String pwd = "1111";

	ResultSet rs = null; // 쿼리문의 결과를 저장하는 변수

	public static patientDAO ptao = null;

	public static patientDAO getInstance() {
		if (ptao == null) {
			ptao = new patientDAO();
		}
		return ptao;
	}

	private patientDAO() {

	}

	public Connection conn() {
		try { // try catch 구문은 예외가 발생할 경우 시스템의 오동작을 방지 하기 위한 구문
			Class.forName(driver); // DB에 접속하기 위한 드라이버 로딩.
			conn = DriverManager.getConnection(url, id, pwd); // db에 접속
			System.out.println("DB연결이 되었습니다.");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 환자가 예약할 메소드
	public void promiss(String id, int day, int a) {
		System.out.println("환자분 아이디와 원하시는 예약 날짜를 입력해주세요 ");
		String sql = "insert into patient values(?,?)";
		PreparedStatement ppst = null;

		if (conn() != null) {
			dable();
			if (a == 1) {
				System.out.println("다시 선택해 주세요");
			} else {

				try {
					ppst = conn.prepareStatement(sql);
					ppst.setString(1, id);
					ppst.setInt(2, day);
					ppst.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						if (ppst != null)
							ppst.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}

	}

//의사가 가능인지 불가능인지 알아볼 메소드
	public int dable() {
		DoctorDTO pt = new DoctorDTO();
		if (pt.getAble() == "unable") {
		}
		return 1;

	}

}
