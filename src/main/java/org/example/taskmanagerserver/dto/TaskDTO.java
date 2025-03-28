package org.example.taskmanagerserver.dto;

import lombok.*;


import java.util.List;


@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private Long id;
    private String title;
    private String status;
    private String background;
    private List<String> tags;
}
