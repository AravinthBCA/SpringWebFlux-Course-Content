package StudentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import StudentManagement.entity.Student;
import StudentManagement.service.StaffService;
import StudentManagement.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StaffService staffService;
	
	@GetMapping("/")
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("index");
	    return mav;
	}
	
//	@GetMapping("/login")
//	public ModelAndView loginPage() {
//		ModelAndView mav = new ModelAndView("Sign_In");
//	    return mav;
//	}
	
	@GetMapping("/student/all")	
	@Operation(summary="Return all Students",description="Returning all Students")
	public @ApiResponse(description="Student Object") ResponseEntity<List<Student>> getallStudents(Model model){
		return new ResponseEntity<List<Student>>(studentService.getAllStudents(),HttpStatus.OK);
	}
	
	@GetMapping("/student/count")
	public ResponseEntity<List<Integer>> getStudentCount(){
		int studentCount = studentService.getStudentCount();
		int staffCount = staffService.getStaffCount();
		return new ResponseEntity<List<Integer>>(List.of(staffCount,studentCount),HttpStatus.OK);
	}
	
	@ModelAttribute("student")
    public Student studentRegistrationDto() {
        return new Student();
    }
	
	@PostMapping(path="/saveStudent")
	public ModelAndView saveStudent(@ModelAttribute("student")Student student) {
		System.out.println(student.toString());
		studentService.saveStudent(student);
		ModelAndView mav = new ModelAndView("index");
	    return mav;
	}
	
	@DeleteMapping("/student/delete/{id}")
	@Operation(summary="Return a Student",description="Returning a Students")
	public @ApiResponse(description="Student Object") ResponseEntity deleteStudent(@Parameter(description="Id of the Product") @PathVariable("id") int id ) {
		System.out.println("id -> "+id);
		studentService.deleteStudent(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
}
