package kr.it.academy.jpa.controller;

import kr.it.academy.jpa.entity.EmployeeEntity;
import kr.it.academy.jpa.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/mem/list")
    public List<EmployeeEntity> findAll() {
        return employeeService.findAll();
    }

    @PostMapping("/mem/add")
    public Map<String , Object> save(@RequestBody EmployeeEntity employee) {
        Map<String , Object> result = new HashMap<>();

        try{
            result = employeeService.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("resultMsg", "등록 실패");
        }

        return result;
    }
}
