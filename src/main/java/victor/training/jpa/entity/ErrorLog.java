package victor.training.jpa.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter

public class ErrorLog {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @Column(name = "message")
   private String message;

   @OneToOne
   @JoinColumn(name = "comment_id")
   private List<ErrorComment> comments = new ArrayList<>();

   @OneToOne
   @JoinColumn(name = "tag_id")
   private Set<ErrorTag> tags = new HashSet<>();

   public ErrorLog() {
   }

   public ErrorLog(String message) {
      this.message = message;
   }



}
