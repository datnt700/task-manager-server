package org.example.taskmanagerserver.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.taskmanagerserver.common.mapper.BoardMapper;
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
        return BoardMapper.entityToDTO(board);
    }

    @Override
    public List<BoardDTO> getAllBoard() {
        List<BoardEntity> boards = boardRepository.findAll();
        return BoardMapper.entityToDtos(boards);
    }
}
