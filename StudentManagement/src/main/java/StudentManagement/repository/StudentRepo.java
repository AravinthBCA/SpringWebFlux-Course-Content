package StudentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import StudentManagement.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{
//public interface StudentRepo extends ReactiveCrudRepository<Student, Integer>{

}
