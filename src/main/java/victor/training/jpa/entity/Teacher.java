package victor.training.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "teacher")
public class Teacher {

	public enum Grade {
		LECTURER("L"),
		PROFESSOR("P"),
		CONF("C"),
		ASSISTANT("A");

		public final String dbValue;
		Grade(String dbValue) {
			this.dbValue = dbValue;
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "grade")
	@Enumerated(EnumType.STRING)
	private Grade grade;

	@OneToOne
	@JoinColumn(name = "details_id")
	private TeacherDetails details;

	// TODO order by type and value ASC
	@OneToMany
	@JoinColumn(name = "id_channel")
//	@OrderBy("channel.type ASC")
	private List<ContactChannel> channels = new ArrayList<>();

	@OneToMany
	@JoinColumn(name = "held_subject_id")
	private Set<Subject> heldSubjects = new HashSet<>() ;

	@OneToMany
	@JoinColumn(name = "id_teaching_activity")
	private Set<TeachingActivity> activities = new HashSet<>();

	@Column(name = "counseling_day")
	private DayOfWeek counselingDay;

	@Column(name = "counseling_start_hour")
	private Integer counselingStartHour;

	@Column(name = "counseling_duration_in_hours")
	private Integer counselingDurationInHours;

	@Column(name = "counseling_room_id")
	private String counselingRoomId;

	public Teacher() {
	}

	public Teacher(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Teacher{" +
			   "id=" + id +
			   ", name='" + name + '\'' +
			   '}';
	}
}
