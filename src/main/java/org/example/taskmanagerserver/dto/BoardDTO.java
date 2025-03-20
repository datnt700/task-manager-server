package org.example.taskmanagerserver.dto;

import lombok.*;

import java.util.List;


@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long id;
    private String name;
    private List<TaskDTO> tasks;
}
