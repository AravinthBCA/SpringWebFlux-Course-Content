package StudentManagement.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="staffs")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="DEPARTMENT")
	private String department;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="MOBILE_NO")
	private Long mobileNo;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="JOINING_DATE")
	private LocalDate joiningDate;
	
	@Column(name="EXPERIENCE")
	private String experience;
	
}










