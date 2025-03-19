package org.example.taskmanagerserver.service;

import org.example.taskmanagerserver.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    public BoardDTO getBoardWithTasks(Long boardId);
    public List<BoardDTO> getAllBoard();
}
