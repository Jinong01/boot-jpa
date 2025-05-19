package kr.it.academy.jpa.controller;

import kr.it.academy.jpa.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/boards")
    public Map<String , Object> getBoardList(@RequestParam(name = "currentPage", defaultValue = "0")int currentPage) {
        Sort sort = Sort.by(Sort.Direction.DESC, "seq");
        PageRequest pageRequest = PageRequest.of(currentPage, 10, sort);
        Map<String , Object> resultMap = new HashMap<>();

        try {
            resultMap = boardService.getBoardList(pageRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    @GetMapping("/boards/{title}")
    public Map<String , Object> searchBoards( @RequestParam(name = "currentPage", defaultValue = "0")int currentPage,
                                              @PathVariable(name = "title") String title) {
        Sort sort = Sort.by(Sort.Direction.DESC, "seq");
        PageRequest pageRequest = PageRequest.of(currentPage, 10, sort);
        Map<String , Object> resultMap = new HashMap<>();
        Map<String , Object> params = new HashMap<>();
        params.put("title", title);
        try {
            resultMap = boardService.searchBoards(pageRequest, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }

}
