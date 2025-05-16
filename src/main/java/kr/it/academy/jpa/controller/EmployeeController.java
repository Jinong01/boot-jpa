package kr.it.academy.jpa.controller;

import kr.it.academy.jpa.dto.EmployeeDto;
import kr.it.academy.jpa.entity.EmployeeEntity;
import kr.it.academy.jpa.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/mem/list")
    public List<EmployeeDto> findAll() {
        return employeeService.findAll3();
    }

    @PostMapping("/mem/add")
    public Map<String , Object> save() {
        Map<String , Object> result = new HashMap<>();

        try{
            result = employeeService.save();
        } catch (Exception e) {
            e.printStackTrace();
            result.put("resultMsg", "등록 실패");
        }

        return result;
    }

    @DeleteMapping("/mem/{emId}")
    public Map<String, Object> delete(@PathVariable("emId") String emId) {
        Map<String, Object> resultMap = new HashMap<>();
        int result = employeeService.delete(emId);

        if(result > 0) {
            resultMap.put("resultMsg", "삭제 성공");
        }else {
            resultMap.put("resultMsg", "삭제 실패");
        }

        return resultMap;
    }
}
