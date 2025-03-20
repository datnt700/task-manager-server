package org.example.taskmanagerserver.common.mapper;

import org.example.taskmanagerserver.dto.TaskDTO;
import org.example.taskmanagerserver.entity.TagEntity;
import org.example.taskmanagerserver.entity.TaskEntity;

import java.util.List;
import java.util.stream.Collectors;

public class TaskMapper {
    public static TaskDTO entityToDTO (TaskEntity taskEntity){
        if (taskEntity == null) {
            return null;
        }
        List<String> tagNames = taskEntity.getTags().stream()
                .map(TagEntity::getName)
                .toList();

        return TaskDTO.builder()
                .id(taskEntity.getId())
                .title(taskEntity.getTitle())
                .status(taskEntity.getStatus())
                .tags(tagNames).build();
    }
}
