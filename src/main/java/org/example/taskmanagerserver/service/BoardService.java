package org.example.taskmanagerserver.service;

import org.example.taskmanagerserver.dto.BoardDTO;

public interface BoardService {
    public BoardDTO getBoardWithTasks(Long boardId);
}
