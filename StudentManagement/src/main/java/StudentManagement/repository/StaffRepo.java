package StudentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import StudentManagement.entity.Staff;

@Repository
public interface StaffRepo extends JpaRepository<Staff, Integer>{
//public interface StudentRepo extends ReactiveCrudRepository<Student, Integer>{

}
