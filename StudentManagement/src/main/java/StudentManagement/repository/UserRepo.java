package StudentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import StudentManagement.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
