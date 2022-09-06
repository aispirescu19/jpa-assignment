package victor.training.jpa.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teaching_activity")
@Getter @Setter
public abstract class TeachingActivity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;

	@Column(name = "day_of_week")
	private DayOfWeek dayOfWeek;

	@Column(name = "start_hour")
	private Integer startHour;

	@Column(name = "duration_in_hours")
	private Integer durationInHours;

	@Column(name = "room_id")
	private String roomId;

	@Column(name = "last_modified_date")
	private LocalDateTime lastModifiedDate;

	@Column(name = "last_modified_by")
	private String lastModifiedBy;

	@OneToMany
	@JoinColumn(name = "teacher_id")
	private Set<Teacher> teachers = new HashSet<>();

}
