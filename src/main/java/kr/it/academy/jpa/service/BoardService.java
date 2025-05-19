package kr.it.academy.jpa.service;

import kr.it.academy.jpa.dto.BoardDto;
import kr.it.academy.jpa.entity.BoardEntity;
import kr.it.academy.jpa.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public Map<String, Object> getBoardList(Pageable pageable) {
        Map<String, Object> map = new HashMap<>();
        Page<BoardEntity> boardPage = boardRepository.findAll(pageable);

        List<BoardDto> boardDtoList =
                boardPage.getContent().stream().map(BoardDto::of).collect(Collectors.toList());

        map.put("total", boardPage.getTotalElements());
        map.put("boardList", boardDtoList);
        map.put("page", boardPage.getNumber());

        return map;
    }

    @Transactional(readOnly = true)
    public Map<String, Object> searchBoards(Pageable pageable, Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>();
        String title = params.get("title").toString();
        System.out.println(title);
        Page<BoardEntity> boardPage = boardRepository.findByTitleContaining(pageable, title);

        List<BoardDto> boardDtoList =
                boardPage.getContent().stream().map(BoardDto::of).collect(Collectors.toList());
        System.out.println(boardDtoList);
        map.put("total", boardPage.getTotalElements());
        map.put("boardList", boardDtoList);
        map.put("page", boardPage.getNumber());

        return map;
    }
}
