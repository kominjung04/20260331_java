package p13Database.dao;

import p13Database.vo.MemberVO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class DAOMember extends DAOSet {
//  table, sequence 생성
//  create table members(
//      mno number, id varchar2(20),
//  pass varchar2(20),name varchar2(20),
//  mobile varchar2(20));
//
//  create SEQUENCE sq_members;

  public MemberVO getMember(Long mno) {
    MemberVO result = null;
    try {
      conn = getConn(); // 연결
      String sql = "select * from members where mno=? ";
      pstmt = conn.prepareStatement(sql); // 질의 객체 생성
      pstmt.setLong(1, mno);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        result = new MemberVO(rs.getLong("mno"), rs.getString("id"),
            rs.getString("pass"), rs.getString("name"),
            rs.getString("mobile"));
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return result;
  }

  public MemberVO checkId(String id) {
    MemberVO result = null;
    try {
      Connection conn = getConn(); // 연결
      String sql = "select * from members where id=? ";
      pstmt = conn.prepareStatement(sql); // 질의 객체 생성
      pstmt.setString(1, id);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        result = new MemberVO(rs.getLong("mno"), rs.getString("id"),
            rs.getString("pass"), rs.getString("name"),
            rs.getString("mobile"));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return result;
  }

  // CRUD create, read, update, delete
  public boolean insertMembers(MemberVO vo) {
    boolean result = false;//회원을 삽입하고 난 후 삽입유무를 확인하는 변수
    try {
      conn = getConn();

      MemberVO tmp = checkId(vo.getId());// 회원 존재 확인
      // 회원 입력전 중복 체크하여 있으면 진행 불가. 여기서 return 마무리
      if (tmp != null) return false; //메서드 리턴타입 boolean

      String sql = "insert into members(mno, id, pass, name, mobile) " +
          "values(sq_members.nextval, ?,?,?,?) ";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, vo.getId());
      pstmt.setString(2, vo.getPass());
      pstmt.setString(3, vo.getName());
      pstmt.setString(4, vo.getMobile());
      int cnt = pstmt.executeUpdate(); // DML: insert, update, delete
      if (cnt == 1) result = true;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return result;
  }

  // 회원등록 후 회원번호를 리턴하는 메서드
  public Long insertMembersMno(MemberVO vo) {
    Long result = -1L; //회원을 삽입하고 난 후 회원번호를 위한 변수

    try {
      conn = getConn();

      MemberVO tmp = checkId(vo.getId());// DB의 동일 ID가 있는지 체크

      if (tmp != null) {
        return -1L; // 없다는 표시로 -1 리턴
      } else {
        // null이면 그런 회원이 없기때문에 등록해야 함.
        String sql = "begin insert into members(mno, id, pass, name, mobile) " +
            "values(sq_members.nextval, ?,?,?,?) RETURNING mno into ?;  end; ";

        cstmt = conn.prepareCall(sql);
        cstmt.setString(1, vo.getId());
        cstmt.setString(2, vo.getPass());
        cstmt.setString(3, vo.getName());
        cstmt.setString(4, vo.getMobile());
        cstmt.registerOutParameter(5, Types.NUMERIC);
        int cnt = cstmt.executeUpdate(); // DML: insert, update, delete
        if (cnt == 1) {
          result = cstmt.getLong(5);
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return result;
  }

  public List<MemberVO> getListMembers() {
    List<MemberVO> result = new ArrayList<>();
    try {
      conn = getConn();
      String sql = "select * from members order by mno ";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        MemberVO vo = new MemberVO(rs.getLong("mno"), rs.getString("id"), rs.getString("pass")
            , rs.getString("name"), rs.getString("mobile"));
        result.add(vo);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return result;
  }

    public boolean modifyMembers(MemberVO vo) {
      boolean result = false;
      try {
        conn = getConn();
        String sql = "update members set pass=?,name=?,mobile=? where id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, vo.getPass());
        pstmt.setString(2, vo.getName());
        pstmt.setString(3, vo.getMobile());
        pstmt.setString(4, vo.getId());

        int cnt = pstmt.executeUpdate();// DML: insert,update,delete
        if (cnt == 1) result = true;

      } catch (SQLException e) {
        throw new RuntimeException(e);
      }finally {
        closeDB();
      }

      return result;
  }

  boolean deleteMember(Long mno) {
    boolean result = false;
    try {
      conn = getConn();
      String sql = "delete from members where mno = ?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setLong(1, mno);

      int cnt = pstmt.executeUpdate();
      if (cnt == 1) result = true;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return result;
  }

}
