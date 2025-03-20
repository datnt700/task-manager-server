package org.example.taskmanagerserver.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="create_at")
    private LocalDate createAt; //local date

    @OneToMany(mappedBy = "board")
    private List<TaskEntity> tasks;
}
