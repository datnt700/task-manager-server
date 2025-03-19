package org.example.taskmanagerserver.service;


import org.example.taskmanagerserver.dto.BoardDTO;
import org.example.taskmanagerserver.dto.TaskDTO;
import org.example.taskmanagerserver.entity.BoardEntity;
import org.example.taskmanagerserver.entity.TagEntity;
import org.example.taskmanagerserver.entity.TaskEntity;
import org.example.taskmanagerserver.repository.BoardRepository;
import org.example.taskmanagerserver.repository.TaskRepository;
import org.example.taskmanagerserver.service.Impl.BoardServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
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

    private BoardEntity boardEntity;
    private BoardEntity boardEntity2;
    private TaskEntity task1;
    private TaskEntity task2;
    private TagEntity tag1;
    private TagEntity tag2;
    private long boardId = 1L;

    @BeforeEach
    void setUp() {
        long boardId = 1L;

        boardEntity = new BoardEntity();
        boardEntity.setId(boardId);
        boardEntity.setName("Test Board");

        boardEntity2 = new BoardEntity();
        boardEntity2.setId(2L);
        boardEntity2.setName("Test Board 2");

        task1 = new TaskEntity();
        task1.setId(1L);
        task1.setTitle("Task 1");
        task1.setStatus("backlog");
        task1.setBackground("Background 1");

        task2 = new TaskEntity();
        task2.setId(2L);
        task2.setTitle("Task 2");
        task2.setStatus("in-progress");
        task2.setBackground("Background 2");

        tag1 = new TagEntity();
        tag1.setName("Technical");
        tag2 = new TagEntity();
        tag2.setName("Frontend");

        task1.setTags(List.of(tag1));
        task2.setTags(List.of(tag2));

        boardEntity.setTasks(Arrays.asList(task1, task2));
        boardEntity2.setTasks(Arrays.asList(task1, task2));
    }


    @Test
    void getBoardWithTasks() {
        // Arrange

        // mô phỏng phương thức findById.
        when(boardRepository.findById(boardId)).thenReturn(java.util.Optional.of(boardEntity));

        // Act
        BoardDTO boardDTO = boardService.getBoardWithTasks(boardId);

        // Assert
        assertNotNull(boardDTO);
        assertEquals(1, boardDTO.getId());
        assertEquals(2, boardDTO.getTasks().size());  //
    }

    @Test
    void getAllBoard() {
        // Arrange

        List<BoardEntity> boardList = List.of(boardEntity, boardEntity2);
        when(boardRepository.findAll()).thenReturn(boardList);

        // Act
        List<BoardDTO> result = boardService.getAllBoard();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());  //
    }
}
