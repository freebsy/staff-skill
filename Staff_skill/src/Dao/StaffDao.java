package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Dto.*;

public class StaffDao {

	Connection conn = null;	
	PreparedStatement stmt = null;
	ResultSet rs = null;
	DBUtil dbUtil = null;
	
	
	public void InsertstaffSkill(Staff staff, Skill skill){
		
		try {
			conn = DBUtil.getConnection(); 
			String sql = "INSERT INTO staffskill(staffno, skillno) values((SELECT no FROM staff WHERE sn=?),?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,staff.getSn());
			stmt.setInt(2,skill.getNo());
			stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, stmt, rs);
		}
	}
	
	public void insertstaff(Staff staff) {
		try{
			conn = DBUtil.getConnection();
			
			School sh = staff.getSchool();
			Religion rg = staff.getReligion();
			
			String sql = "INSERT INTO staff(name,sn,graduateday,schoolno,religionno) values(?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,staff.getName());
			stmt.setString(2,staff.getSn());
			stmt.setString(3,staff.getGraduateday());
			stmt.setInt(4,staff.getSchool().getNo());
			stmt.setInt(5,staff.getReligion().getNo());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, stmt, rs);
		}
			
	}
	
	//종교
	public ArrayList<Religion> selectreligion() {
		ArrayList<Religion> als = new ArrayList<Religion>();
		Religion rg = new Religion();
		try{
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM religion ORDER BY no asc";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				rg = new Religion();
				rg.setNo(rs.getInt("no"));
				rg.setName(rs.getString("name"));
				als.add(rg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, stmt, rs);
		}
		return als;
	}

	//학력
	public ArrayList<School> selectSchool() {
		ArrayList<School> als = new ArrayList<School>();
		School sh = new School();
		try{
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM school ORDER BY no asc";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				sh = new School();
				sh.setNo(rs.getInt("no"));
				sh.setGraduate(rs.getString("graduate"));
				als.add(sh);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, stmt, rs);
		}
		return als;
	}

	//스킬 dao
	public ArrayList<Skill> selectSkill() {
		ArrayList<Skill> als = new ArrayList<Skill>();
		Skill sk = new Skill();
		try{
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM SKILL ORDER BY no asc";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				sk = new Skill();
				sk.setNo(rs.getInt("no"));
				sk.setName(rs.getString("name"));
				als.add(sk);
			}
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, stmt, rs);
		}
		return als;
	}

	
}
