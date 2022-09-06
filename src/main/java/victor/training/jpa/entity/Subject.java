package victor.training.jpa.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter

@Entity
@Table(name = "subject")
public class Subject  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "active")
	private boolean active;

	@ManyToOne
	@JoinColumn(name = "holder_teacher_id")
	private Teacher holderTeacher;

	@OneToMany
	@JoinColumn(name = "activities_id")
	private List<TeachingActivity> activities = new ArrayList<>();

	@Column(name = "last_modified_date")
	private LocalDateTime lastModifiedDate;
	@Column(name = "last_modified_by")
	private String lastModifiedBy;

	public Subject() {
	}

	public Subject(String name) {
		this.name = name;
	}
}
