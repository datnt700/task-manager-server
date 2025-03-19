package org.example.taskmanagerserver.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
public class BoardDTO {
    private Long id;
    private List<TaskDTO> tasks;
}
