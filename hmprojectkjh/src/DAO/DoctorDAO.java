package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.DoctorDTO;

public class DoctorDAO {
	private Connection conn = null; // oracle 접속하기 위한 연결 컨넥션
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String id = "system";
	private String pwd = "1111";

	ResultSet rs = null; // 쿼리문의 결과를 저장하는 변수
	
	
	public static DoctorDAO ddao=null;
	public static DoctorDAO getInstance() {
		if (ddao== null) {
			ddao = new DoctorDAO();
		}
		return ddao;}
	private DoctorDAO() {
		
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

//의사 리스트 뽑기
	public ArrayList<DoctorDTO> selectdoctor() {
		String sql = "select * from doctor";
		Statement st = null;
		ArrayList<DoctorDTO> list = new ArrayList<>();
		if (conn() != null) {
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while (rs.next()) {
					DoctorDTO temp = new DoctorDTO();
					temp.setNo(rs.getInt("no"));
					temp.setDoctor(rs.getString("doctor"));
					temp.setDay(rs.getInt("day"));
					temp.setAble(rs.getString("able"));
					list.add(temp);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (st != null)
						st.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;}
	

	// 환자가 예약을 잡으면 unable로 바뀌줄 동작 메소드
	public void updateable(int day) {
//		DoctorDTO d = new DoctorDTO();
		String sql = "update doctor set able='unable' where day=?";
		PreparedStatement ppst = null; // 동적쿼리문
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setInt(1, day);
				ppst.executeUpdate();
				
			} catch (Exception e) {
				System.out.println("업데이트 실패");
				e.printStackTrace();
		}
			finally {
				try {
				if (ppst != null)
						ppst.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e2) {
				// TODO Auto-generated catch block
					e2.printStackTrace();

		}
		}
	}
}}
