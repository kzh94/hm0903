package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.DoctorDTO;

public class patientDAO {

	private Connection conn = null; // oracle �����ϱ� ���� ���� ���ؼ�
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String id = "system";
	private String pwd = "1111";

	ResultSet rs = null; // �������� ����� �����ϴ� ����

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

	// ȯ�ڰ� ������ �޼ҵ�
	public void promiss(String id, int day, int a) {
		System.out.println("ȯ�ں� ���̵�� ���Ͻô� ���� ��¥�� �Է����ּ��� ");
		String sql = "insert into patient values(?,?)";
		PreparedStatement ppst = null;

		if (conn() != null) {
			dable();
			if (a == 1) {
				System.out.println("�ٽ� ������ �ּ���");
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

//�ǻ簡 �������� �Ұ������� �˾ƺ� �޼ҵ�
	public int dable() {
		DoctorDTO pt = new DoctorDTO();
		if (pt.getAble() == "unable") {
		}
		return 1;

	}

}
