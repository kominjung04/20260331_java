package p13Database.dao;

import java.sql.*;

public class DAOSet {
  Connection conn; // DB와 연결하는 객체
  PreparedStatement pstmt; // Query를 관리하는 객체
  Statement stmt; // Query 관리 객체
  CallableStatement cstmt; // Query 관리 객체인데 리턴이 있는 경우
  ResultSet rs; // .Query 실행 후 결과를 관리하는 객체

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
