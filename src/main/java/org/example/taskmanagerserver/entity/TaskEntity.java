package org.example.taskmanagerserver.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name="title")
    private String title;

    @Column(name="status")
    private String status;

    @Column(name="background")
    private String background;

    @ManyToOne
    @JoinColumn(name = "board_id", referencedColumnName = "id")
    private BoardEntity board;

//    @JoinTable chỉ ra rằng bảng task_tag sẽ lưu trữ mối quan hệ giữa TaskEntity và TagEntity.
//            joinColumns = @JoinColumn(name = "task_id"): Mỗi bản ghi trong bảng task_tag sẽ lưu task_id liên kết với một TaskEntity.
//    inverseJoinColumns = @JoinColumn(name = "tag_id"): Mỗi bản ghi trong bảng task_tag sẽ lưu tag_id liên kết với một TagEntity.
    @ManyToMany
    @JoinTable(
            name = "task_tag",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<TagEntity> tags;

}
