package victor.training.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter

public class StudentsGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String code;

	@Column(name = "name")
	private StudentsYear year;

	@ManyToOne
	@JoinColumn(name = "lab_activity_id")
	private Set<LabActivity> labs = new HashSet<>();

	@Column(name = "emails")
	private List<String> emails = new ArrayList<>();

	public StudentsGroup() {
	}
	public StudentsGroup(String code) {
		this.code = code;
	}

}
