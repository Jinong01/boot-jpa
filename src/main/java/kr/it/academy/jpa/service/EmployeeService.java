package kr.it.academy.jpa.service;

import kr.it.academy.jpa.entity.EmployeeEntity;
import kr.it.academy.jpa.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }

    public Map<String, Object> save(EmployeeEntity employee) {
        employeeRepository.save(employee);
        Map<String, Object> result = new HashMap<>();
        result.put("resultMsg", "등록 성공");
        return result;
    }
}
