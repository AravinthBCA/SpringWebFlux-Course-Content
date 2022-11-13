package StudentManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import StudentManagement.entity.Staff;
import StudentManagement.repository.StaffRepo;

@Service
public class StaffService {
	
	@Autowired
	private StaffRepo staffRepo;
	
	public List<Staff> getAllStaffs(){
		return staffRepo.findAll();
	}
	
	public Staff saveStaff(Staff staff) {
		return staffRepo.save(staff);
	}
	
	public int getStaffCount() {
		return (int) staffRepo.count();
	}
	
}
