package victor.training.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

public class CourseActivity extends TeachingActivity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private StudentsYear year;

}
