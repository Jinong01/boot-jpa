package kr.it.academy.jpa.service;

import kr.it.academy.jpa.entity.BoardEntity;
import kr.it.academy.jpa.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Map<String, Object> getBoardList(@RequestParam(name = "currentPage",defaultValue = "0")
                                            int currentPage) {

        Pageable pageable = PageRequest.of(currentPage, 10, Sort.Direction.DESC, "boardId");
        Map<String, Object> map = new HashMap<String, Object>();

        Page<BoardEntity> boardList = boardRepository.findAll(pageable);


        return map;
    }
}
