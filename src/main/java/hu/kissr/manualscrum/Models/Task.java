package hu.kissr.manualscrum.Models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Project")
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_generator")
    @SequenceGenerator(name = "task_generator", sequenceName = "task_seq")
    private Integer id;

    private String title;
    private String description;
    private Integer position;
    private Integer sprintId;
}
