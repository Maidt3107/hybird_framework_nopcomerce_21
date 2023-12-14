package jdbcTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServerJTDSTestConnection {

	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
		return SQLServerJTDSConnUtils.getSQLServerConnection();
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("Get connection... ");

		// Lấy ra đối tượng Connection kết nối vào database.
		Connection conn = SQLServerJTDSTestConnection.getMyConnection();

		System.out.println("Opened connection: " + conn);

		Statement statement = conn.createStatement();

		String sql = "SELECT * FROM [automationtest].[dbo].[Product_Type];";
		String insertSql = "INSERT INTO [automationtest].[dbo].[BRANCH] ([ADDRESS],[CITY],[NAME],[STATE],[ZIP_CODE]) VALUES ('106 Tran Quoc Tuan', 'Ho Chi Minh', 'Honda', 'HC', '61000')";

		int rowCount = statement.executeUpdate(insertSql);
		System.out.println("Row Count affected = " + rowCount);
		
		// Thực thi câu lệnh SQL trả về đối tượng ResultSet.
		ResultSet rs = statement.executeQuery(sql);

		// Duyệt trên kết quả trả về
		while (rs.next()) {
			// Di chuyển con trỏ xuống bản ghi kế tiếp.
			//String empFirstName = rs.getString(1);
			//String empLastName = rs.getString("NAME");

			System.out.println("--------------------");
			System.out.println(rs.getInt("BRANCH_ID"));
			System.out.println(rs.getString("ADDRESS"));
			System.out.println(rs.getString("CITY"));
			System.out.println(rs.getString("NAME"));
			System.out.println(rs.getString("STATE"));
			System.out.println(rs.getString("ZIP_CODE"));
			
		}
		// Đóng kết nối
		conn.close();
		System.out.println("---------- Closed connection ----------");
	}

}
