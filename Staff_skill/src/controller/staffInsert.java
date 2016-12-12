package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.*;
import Dto.*;

/**
 * Servlet implementation class staffInsert
 */
@WebServlet("/staff/staffinsert")
public class staffInsert extends HttpServlet {
	private StaffDao dao;
	private Staff staff;
	private Religion religion;
	private Skill skill;
	private School school;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Religion rg = new Religion();
		School school = new School();
		Skill skill = new Skill();
		StaffDao dao = new StaffDao();
		
		ArrayList<School> shList = dao.selectSchool();
		ArrayList<Skill>  skList = dao.selectSkill();
		ArrayList<Religion> rgList = dao.selectreligion();
		
		request.setAttribute("shList", shList);
		request.setAttribute("skList", skList);
		request.setAttribute("rgList", rgList);
		request.getRequestDispatcher("/staff/staffInsert.jsp").forward(request, response);
	}
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.setCharacterEncoding("euc-kr");
	        
	        String[] str = request.getParameterValues("skillno");
	        String name = request.getParameter("name");
	        String sn1 = request.getParameter("sn1");
	        String sn2 = request.getParameter("sn2");
	        String sn = sn1 + "/" +sn2;
	        
	        int religionno = Integer.parseInt(request.getParameter("religionno"));
	        int schoolno = Integer.parseInt(request.getParameter("schoolno"));
	       
	        String graduateDay = request.getParameter("graduateDay");
	 
	        school = new School();
	        school.setNo(schoolno);
	        
	        religion = new Religion();
	        religion.setNo(religionno);
	 
	        staff = new Staff();
	        dao = new StaffDao();
	           
	        staff.setName(name);
	           staff.setSn(sn);
	           staff.setReligion(religion);
	           staff.setSchool(school);
	           staff.setGraduateday(graduateDay);
	           dao.insertstaff(staff);
	                 
	           int[] skillno = new int[str.length];
	        for(int i=0; i<str.length; i++){
	        	skillno[i]= Integer.parseInt(str[i]);
	            	System.out.println(skillno[i] +": <--skillno[i]");
	            Skill skill = new Skill();                     
	            skill.setNo(skillno[i]);
	            dao.InsertstaffSkill(staff, skill);
	        }
	           response.sendRedirect(request.getContextPath()+"/StaffSearch");
	 } 
}
