package victor.training.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "teacher_details")
@Getter @Setter
public class TeacherDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;
	
	// TODO : what if this grows very big?
	@Column(name = "cv")
	private String cv;

}
