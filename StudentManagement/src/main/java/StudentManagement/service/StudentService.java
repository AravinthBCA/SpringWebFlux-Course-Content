package StudentManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import StudentManagement.entity.Student;
import StudentManagement.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	public List<Student> getAllStudents(){
		return studentRepo.findAll();
	}
	
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}
	
	public void deleteStudent(int id) {
		studentRepo.deleteById(id);
	}
	
	public int getStudentCount() {
		return (int) studentRepo.count();
	}
	
}
