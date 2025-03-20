package org.example.taskmanagerserver.common.mapper;

import org.example.taskmanagerserver.dto.BoardDTO;
import org.example.taskmanagerserver.dto.TaskDTO;
import org.example.taskmanagerserver.entity.BoardEntity;

import java.util.List;

public class BoardMapper {
    public static BoardDTO entityToDTO (BoardEntity boardEntity){
        if (boardEntity == null) {
            return null;
        }
        List<TaskDTO> taskDTOList = boardEntity.getTasks().stream().map(TaskMapper::entityToDTO).toList();
        return BoardDTO.builder()
                .id(boardEntity.getId())
                .name(boardEntity.getName())
                .tasks(taskDTOList).build();
    }

    public static List<BoardDTO> entityToDtos (List<BoardEntity> boardEntities){
        return boardEntities.stream().map(BoardMapper::entityToDTO).toList();
    }
}
