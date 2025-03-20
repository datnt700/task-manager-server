package org.example.taskmanagerserver.controller;

import lombok.RequiredArgsConstructor;
import org.example.taskmanagerserver.common.exception.ResourceNotFoundException;
import org.example.taskmanagerserver.dto.BoardDTO;
import org.example.taskmanagerserver.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/{id}")
    public ResponseEntity<BoardDTO> getBoard(@PathVariable Long id) throws ResourceNotFoundException {
            BoardDTO boardDTO = boardService.getBoardWithTasks(id);
            return ResponseEntity.status(HttpStatus.OK).body(boardDTO);
    }

    @GetMapping("")
    public ResponseEntity<List<BoardDTO>> getAllBoard(){
        List<BoardDTO> boardDTOS = boardService.getAllBoard();
        return ResponseEntity.status(HttpStatus.OK).body(boardDTOS);
    }
}
