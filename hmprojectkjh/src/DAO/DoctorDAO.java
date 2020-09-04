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
	private Connection conn = null; // oracle �����ϱ� ���� ���� ���ؼ�
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String id = "system";
	private String pwd = "1111";

	ResultSet rs = null; // �������� ����� �����ϴ� ����
	
	
	public static DoctorDAO ddao=null;
	public static DoctorDAO getInstance() {
		if (ddao== null) {
			ddao = new DoctorDAO();
		}
		return ddao;}
	private DoctorDAO() {
		
	}
		
	
	public Connection conn() {
		try { // try catch ������ ���ܰ� �߻��� ��� �ý����� �������� ���� �ϱ� ���� ����
			Class.forName(driver); // DB�� �����ϱ� ���� ����̹� �ε�.
			conn = DriverManager.getConnection(url, id, pwd); // db�� ����
			System.out.println("DB������ �Ǿ����ϴ�.");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

//�ǻ� ����Ʈ �̱�
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
	

	// ȯ�ڰ� ������ ������ unable�� �ٲ��� ���� �޼ҵ�
	public void updateable(int day) {
//		DoctorDTO d = new DoctorDTO();
		String sql = "update doctor set able='unable' where day=?";
		PreparedStatement ppst = null; // ����������
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setInt(1, day);
				ppst.executeUpdate();
				
			} catch (Exception e) {
				System.out.println("������Ʈ ����");
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
