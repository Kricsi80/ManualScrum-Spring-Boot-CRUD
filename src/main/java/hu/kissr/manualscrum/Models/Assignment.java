package hu.kissr.manualscrum.Models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Assignment")
@Getter
@Setter
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "assignment_generator")
    @SequenceGenerator(name = "assignment_generator", sequenceName = "assignment_seq")
    private Integer id;

    private Integer employeeId;
    private Integer taskId;
}
