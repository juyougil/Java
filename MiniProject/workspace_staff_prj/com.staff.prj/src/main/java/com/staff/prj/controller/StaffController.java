package com.staff.prj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.staff.prj.dao.StaffDAO;
import com.staff.prj.dto.StaffDTO;
import com.staff.prj.dto.StaffSearchDTO;
import com.staff.prj.info.Info;
import com.staff.prj.service.StaffService;
import com.staff.prj.util.Util;
import com.staff.prj.validator.StaffValidator;


@Controller
public class StaffController {
	
	@Autowired
	private StaffDAO staffDAO;
	@Autowired
	private StaffService staffService;
	
	private String path = Info.staffPath;
	
	@RequestMapping(value="/staff_search_form.do")
	public ModelAndView getStaffList(
			StaffSearchDTO staffSearchDTO
			,@RequestParam(value="searchSuccess"		
			, required=false				
			, defaultValue="0") String searchSuccess
			
	) {
		int staffListAllCnt = this.staffDAO.getStaffListAllCnt(staffSearchDTO);
		
		

		Map<String,Integer> map = Util.getPagingNos(staffListAllCnt, staffSearchDTO.getSelectPageNo(), staffSearchDTO.getRowCntPerPage(), 10);
		

		staffSearchDTO.setSelectPageNo(map.get("selectPageNo"));	
		

		
		
		List<Map<String,String>> staffList = this.staffDAO.getStaffList(staffSearchDTO);
		List<Map<String,String>> skillList = this.staffDAO.getSkillList();
		List<Map<String,String>> religionList = this.staffDAO.getReligionList();
		List<Map<String,String>> schoolList = this.staffDAO.getSchoolList();
		String min_year=this.staffDAO.getMin_Year();
		String max_year=this.staffDAO.getMax_Year();
		String sysdate = this.staffDAO.getSYSDATE();
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path+"search_form.jsp");
		mav.addObject("staffList",staffList);
		mav.addObject("staffListAllCnt",staffListAllCnt);
		mav.addObject("skillList",skillList);
		mav.addObject("religionList",religionList);
		mav.addObject("schoolList",schoolList);
		mav.addObject("min_year",min_year);
		mav.addObject("max_year",max_year);
		mav.addObject("pagingNos",map );
		mav.addObject("searchSuccess",searchSuccess );
		mav.addObject("sysdate",sysdate);

		return mav;
	}
	
	
	
	@RequestMapping(value="/staff_input_form.do")
	public ModelAndView goEmployeeRegForm(
		
		) {
		
		String sysdate = this.staffDAO.getSYSDATE();
		List<Map<String,String>> skillList = this.staffDAO.getSkillList();
		List<Map<String,String>> religionList = this.staffDAO.getReligionList();
		List<Map<String,String>> schoolList = this.staffDAO.getSchoolList();
		

		ModelAndView mav = new ModelAndView();
		mav.setViewName(path+"input_form.jsp");
		mav.addObject("skillList",skillList);
		mav.addObject("religionList",religionList);
		mav.addObject("schoolList",schoolList);
		mav.addObject("sysdate",sysdate);
		return mav;
	}	

	
	
	
	
	
	
	@RequestMapping(
			value="/staff_Input_proc.do"
			,method=RequestMethod.POST
			,produces="application/json;charset=UTF-8"
			
	)
	@ResponseBody
	public Map<String,String> insertBoard(
			StaffDTO staffDTO
			,BindingResult bindingResult
	) {
		
		

		int inputStaffCnt =0;

		String msg = "";
		

			msg = check_BoardDTO(staffDTO,bindingResult);
			
			
			if(msg.equals("")) {

			inputStaffCnt = this.staffService.inputStaff(staffDTO);

			}


		 

		Map<String,String> map = new HashMap<String,String>();
		

		map.put("inputStaffCnt", inputStaffCnt+"");
		

		map.put("msg", msg);
		

		return map;
	}
	
	
	


	public String check_BoardDTO(StaffDTO staffDTO ,BindingResult bindingResult) {
		String checkMsg="";


		StaffValidator staffValidator = new StaffValidator();
		staffValidator.validate(
				staffDTO	
				,bindingResult	
		);
	
		if(bindingResult.hasErrors()) {
		
			checkMsg = bindingResult.getFieldError().getCode();
		}
		
		
		return checkMsg;
		
		
	}
	

	@RequestMapping(value="/staff_updel_form.do")
	

	public ModelAndView goBoardUpDelForm(
			@RequestParam(value="staff_no") int staff_no	
	) {
		
		
		StaffDTO  staffDTO = this.staffDAO.getStaff(staff_no);
		List<Map<String,String>> staffSkill = this.staffDAO.getStaffSkill(staff_no);

		String sysdate = this.staffDAO.getSYSDATE();
		

		
		List<Map<String,String>> skillList = this.staffDAO.getSkillList();
		List<Map<String,String>> religionList = this.staffDAO.getReligionList();
		List<Map<String,String>> schoolList = this.staffDAO.getSchoolList();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path+"updel_form.jsp");
		mav.addObject("staffDTO",staffDTO);
		
		
		mav.addObject("sysdate",sysdate);
		mav.addObject("skillList",skillList);
		mav.addObject("religionList",religionList);
		mav.addObject("schoolList",schoolList);
		mav.addObject("staffSkill",staffSkill);
		return mav;
		
	}
	
	
	@RequestMapping(
			value="/staff_updel_proc.do"
			,method=RequestMethod.POST
			,produces="application/json;charset=UTF-8"
			
	)
	@ResponseBody
	public Map<String,String> boardUpDelProc(
			
			StaffDTO staffDTO				
			
			,@RequestParam(value="upDel") String upDel	

			,BindingResult bindingResult
	){

		int staffUpDelCnt=0;

		String msg = "";

		if(upDel.equals("del")) {

			staffUpDelCnt = this.staffService.deleteStaff(staffDTO);
			
		}

		else if(upDel.equals("up")) {

			msg = check_BoardDTO(staffDTO,bindingResult);
			
			

			if(msg.equals("")) {

				staffUpDelCnt = this.staffService.updateStaff(staffDTO);
				
				
			}
			
			else {
			}		
			
		}
		


		Map<String,String> map = new HashMap<String,String>();
		map.put("staffUpDelCnt", staffUpDelCnt+"");
		map.put("msg", msg);
		return map;
	}
	
	
	
	
	
	
	
	
}
