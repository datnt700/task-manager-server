package org.example.taskmanagerserver.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.config.Task;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tag")
public class TagEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name="name")
    private String name;

    //mappedBy, Spring JPA biết rằng bảng trung gian sẽ được
    // quản lý ở phía TaskEntity (vì TaskEntity có @JoinTable),
    @ManyToMany(mappedBy = "tags")
    private List<TaskEntity> tasks;
}
