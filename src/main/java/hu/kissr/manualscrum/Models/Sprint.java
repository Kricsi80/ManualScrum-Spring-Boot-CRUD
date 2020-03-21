package hu.kissr.manualscrum.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Sprint")
@Getter
@Setter
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sprint_generator")
    @SequenceGenerator(name = "sprint_generator", sequenceName = "sprint_seq")
    private Integer id;

    private Boolean isFinished;
    private Date createdAt;
    private Integer projectId;
}
