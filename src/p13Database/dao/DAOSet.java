package p13Database.dao;

import java.sql.*;

//DB연결을 위한 설정 객체
public class DAOSet {
  Connection conn; // DB와 연결하는 객체
  Statement stmt; // Query 관리 객체
  PreparedStatement pstmt; // 쿼리 관리하는 객체, 복수개를 사용할 경우
  CallableStatement cstmt; // 쿼리 관리 객체, 복수개, 리턴이 있는 경우
  ResultSet rs; // 쿼리 실행 후 결과를 관리하는 객체

  //private DAOSet() {}

  // Connection을 획득하기 위한 메서드
  public Connection getConn() throws SQLException {
    String driver = "jdbc:oracle:thin:@localhost:1521:xe";
    String user = "scott", pass = "tiger";
    conn = DriverManager.getConnection(driver, user, pass);
    return conn;
  }

  // Connection을 끊을 때
  public void closeDB() {
    try {
      if (rs != null) rs.close();
      if (pstmt != null) pstmt.close();
      if (stmt != null) stmt.close();
      if (cstmt != null) cstmt.close();
      if (conn != null) conn.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

}
