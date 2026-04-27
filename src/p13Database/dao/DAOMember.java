package p13Database.dao;

import p13Database.vo.MemberVO;

import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DAOMember extends DAOSet {
//   table,sequence 생성
//  create table
//  members(
//      mno number,
//      id varchar2(20),
//  pass varchar2(20),
//  name varchar2(20),
//  mobile varchar2(20));
//
//  create SEQUENCE sq_members;

public MemberVO getMember(Long mno) {
  MemberVO result = null;
  try {
    conn = getConn(); //연결
    String sql = "select * from members where mno = ? "; //?에 mno가 들어감
    pstmt = conn.prepareStatement(sql); //질의 객체 생성
    pstmt.setLong(1,mno); //database는 1번부터 시작
    rs = pstmt.executeQuery(); //select만 executeQuery
    if (rs.next()) {
      result = new MemberVO(rs.getLong("mno"),
          rs.getString("id"),
          rs.getString("pass"),
          rs.getString("name"),
          rs.getString("mobile"));
    }

  } catch (SQLException e) {
    throw new RuntimeException(e);
  }finally {
    closeDB();
  }
  return result;
}

  public MemberVO checkId(String id) {
    MemberVO result = null;
    try {
      conn = getConn(); //연결
      String sql = "select * from members where id = ?"; //?에 mno가 들어감
      pstmt = conn.prepareStatement(sql); //질의 객체 생성
      pstmt.setString(1,id);
      rs = pstmt.executeQuery(); //select만 executeQuery
      if (rs.next()) {
        result = new MemberVO(rs.getLong("mno"),
            rs.getString("id"),
            rs.getString("pass"),
            rs.getString("name"),
            rs.getString("mobile"));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }finally {
      closeDB();
    }
    return result;
  }

  // CRUD :: create read update delete
  public boolean insertMembers(MemberVO vo) {
    boolean result = false; // 회원을 삽입하고 난 후 삽임유무를 확인하는 변수
    try {
      conn = getConn();
      MemberVO tmp = checkId(vo.getId());

      //회원 입력 전 중복 체크 하여 있으면 진행 불가, 여기서 return 마무리
      if (tmp.getId().equals(vo.getId())) return false; // 메서드의 리턴타입 boolean

      String sql = "insert into members values(sq_members.nextvar,?,?,?,?) ";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1,vo.getId());
      pstmt.setString(2,vo.getPass());
      pstmt.setString(3,vo.getName());
      pstmt.setString(4,vo.getMobile());

      int cnt = pstmt.executeUpdate();// DML: insert,update,delete
      if (cnt == 1) result = true;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }finally {
      closeDB();
    }
    return result;
  }

  //회원등록 후 회원번호를 리턴하는 메서드
  public Long insertMembersMno(MemberVO vo) {
    Long result = -1l; //회원을 삽입하고 난 후 회원번호를 위한 변수
    try {
      conn = getConn();
      MemberVO tmp = checkId(vo.getId()); //회원 존재 확인

      //회원 입력 전 중복 체크 하여 있으면 진행 불가, 여기서 return 마무리
      if (tmp.getId().equals(vo.getId())) return -1L; // 메서드 리턴타입 Long

      String sql = "insert into members (mno, id, pass, name, mobile) " +
          "RETURNING mno into ? ";//mno를 돌려 받는다
      cstmt = conn.prepareCall(sql);
      cstmt.setString(1,vo.getId());
      cstmt.setString(2,vo.getPass());
      cstmt.setString(3,vo.getName());
      cstmt.setString(4,vo.getMobile());
      cstmt.registerOutParameter(5, Types.INTEGER);
      int cnt = cstmt.executeUpdate();// DML: insert,update,delete
      if (cnt == 1) result = cstmt.getLong(5);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }finally {
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
        MemberVO vo = new MemberVO(rs.getLong("mno"),
            rs.getString("id"),rs.getString("pass"),
            rs.getString("name"),rs.getString("mobile"));
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
      String sql = "update memebers set pass=?,name=?,mobile=?, where id=?";
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

  boolean deleteMembers(Long mno){
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

