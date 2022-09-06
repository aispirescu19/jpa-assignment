package victor.training.jpa.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "channel")
public class ContactChannel {

	public enum Type {
		PERSONAL_PHONE,
		WORK_PHONE,
		PERSONAL_EMAIL,
		WORK_EMAIL,
		TWITTER,
		FACEBOOK,
		LINKED_IN
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private String id;

	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private Type type;

	protected ContactChannel() {
	}

	public ContactChannel(Type type, String id) {
		this.type = type;
		this.id = id;
	}

}
