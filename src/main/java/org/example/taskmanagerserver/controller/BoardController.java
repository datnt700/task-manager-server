package org.example.taskmanagerserver.controller;

import lombok.RequiredArgsConstructor;
import org.example.taskmanagerserver.dto.BoardDTO;
import org.example.taskmanagerserver.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/{id}")
    public ResponseEntity<BoardDTO> getBoard(@PathVariable Long id) {
        try {
            BoardDTO boardDTO = boardService.getBoardWithTasks(id);
            return ResponseEntity.status(HttpStatus.OK).body(boardDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<BoardDTO>> getAllBoard(){
        List<BoardDTO> boardDTOS = boardService.getAllBoard();
        return ResponseEntity.status(HttpStatus.OK).body(boardDTOS);
    }
}
