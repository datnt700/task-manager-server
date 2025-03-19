package org.example.taskmanagerserver.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@RequiredArgsConstructor
public class TaskDTO {
    private Long id;
    private String title;
    private String status;
    private String background;
    private List<String> tags;
}
