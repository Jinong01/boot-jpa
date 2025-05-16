package kr.it.academy.jpa.controller;

import kr.it.academy.jpa.dto.DepartmentDto;
import kr.it.academy.jpa.entity.DepartmentEntity;
import kr.it.academy.jpa.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/dept/list")
    public List<DepartmentDto> findDepartAll(){
        return departmentService.findDepartAll();
    }
}
