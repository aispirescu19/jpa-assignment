package victor.training.jpa.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.time.DayOfWeek;

@Entity
@Table(name = "time_slot")
@Getter @ToString
public class TimeSlot {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

//	@Column(name = "day")
//	private DayOfWeek day;
//	// embeddable names are contextualized using spring.jpa.hibernate.naming.implicit-strategy=org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl

	@Column(name = "start_hour")
	private int startHour;

	@Column(name = "hours")
	private int hours;

	@Column(name = "room_id")
	private String roomId;

	public void setId(Long id) {
		this.id = id;
	}

	protected TimeSlot() {}

	public TimeSlot(DayOfWeek day, int startHour, int hours, String roomId) {
		//this.day = day;
		this.startHour = startHour;
		this.hours = hours;
		this.roomId = roomId;
	}

}
