package StudentManagement.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import StudentManagement.entity.Staff;
import StudentManagement.service.StaffService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	@GetMapping("/staff/all")	
	@Operation(summary="Return all Staffs",description="Returning all Staffs")
	public @ApiResponse(description="Staff Object") ResponseEntity<List<Staff>> getallStaffs(Model model){
		return new ResponseEntity<List<Staff>>(staffService.getAllStaffs(),HttpStatus.OK);
	}
	
	@PostMapping(path="/saveStaff")
	public ModelAndView saveStaff(@ModelAttribute("staff")Staff staff) {
//		staff.setJoiningDate(LocalDate.now());
		staffService.saveStaff(staff);
		ModelAndView mav = new ModelAndView("index");
	    return mav;
	}
	
}
