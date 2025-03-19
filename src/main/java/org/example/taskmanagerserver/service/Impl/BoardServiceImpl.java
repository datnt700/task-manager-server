package org.example.taskmanagerserver.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.taskmanagerserver.dto.BoardDTO;
import org.example.taskmanagerserver.dto.TaskDTO;
import org.example.taskmanagerserver.entity.BoardEntity;
import org.example.taskmanagerserver.entity.TagEntity;
import org.example.taskmanagerserver.repository.BoardRepository;
import org.example.taskmanagerserver.service.BoardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    @Override
    public BoardDTO getBoardWithTasks(Long boardId){
        BoardEntity board = boardRepository.findById(boardId).orElseThrow(() -> new RuntimeException("Board not found"));

        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(board.getId());

        List<TaskDTO> taskDTOs = board.getTasks().stream() // Tạo một stream từ collection
                .map(task -> { // chuyển đổi (mapping) dữ liệu từ đối tượng TaskEntity sang đối tượng TaskDTO
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setId(task.getId());
            taskDTO.setTitle(task.getTitle());
            taskDTO.setStatus(task.getStatus());
            taskDTO.setBackground(task.getBackground());
            taskDTO.setTags(task.getTags().stream().map(TagEntity::getName)// TagEntity::getName method reference === tag -> tag.getName()
                    .collect(Collectors.toList()));
            return taskDTO;
        }).collect(Collectors.toList());

        boardDTO.setTasks(taskDTOs);
        return boardDTO;
    }
}
