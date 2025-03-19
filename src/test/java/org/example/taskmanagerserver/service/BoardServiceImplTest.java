package org.example.taskmanagerserver.service;


import org.example.taskmanagerserver.dto.BoardDTO;
import org.example.taskmanagerserver.entity.BoardEntity;
import org.example.taskmanagerserver.entity.TagEntity;
import org.example.taskmanagerserver.entity.TaskEntity;
import org.example.taskmanagerserver.repository.BoardRepository;
import org.example.taskmanagerserver.repository.TaskRepository;
import org.example.taskmanagerserver.service.Impl.BoardServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BoardServiceImplTest {
//    Tạo ra các đối tượng giả (mock objects) cho các lớp hoặc interface mà bạn không muốn sử dụng
    @Mock
    private BoardRepository boardRepository;

//    Tạo một đối tượng thực của class mà bạn muốn test
    @InjectMocks
    private BoardServiceImpl boardService;

    @Test
    void getBoardWithTasks() {
        // Arrange
        long boardId = 1L;
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId(boardId);
        boardEntity.setName("Test Board");

        TaskEntity task1 = new TaskEntity();
        task1.setId(1L);
        task1.setTitle("Task 1");
        task1.setStatus("backlog");
        task1.setBackground("Background 1");

        TaskEntity task2 = new TaskEntity();
        task2.setId(2L);
        task2.setTitle("Task 2");
        task2.setStatus("in-progress");
        task2.setBackground("Background 2");

        TagEntity tag1 = new TagEntity();
        tag1.setName("Technical");
        TagEntity tag2 = new TagEntity();
        tag2.setName("Frontend");

        task1.setTags(List.of(tag1));
        task2.setTags(List.of(tag2));

        boardEntity.setTasks(Arrays.asList(task1, task2));

        // mô phỏng phương thức findById.
        when(boardRepository.findById(boardId)).thenReturn(java.util.Optional.of(boardEntity));

        // Act
        BoardDTO boardDTO = boardService.getBoardWithTasks(boardId);

        // Assert
        assertNotNull(boardDTO);
        assertEquals(1, boardDTO.getId());
        assertEquals(2, boardDTO.getTasks().size());  //
    }
}
