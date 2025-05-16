package kr.it.academy.jpa.service;

import kr.it.academy.jpa.entity.DepartmentEntity;
import kr.it.academy.jpa.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<DepartmentEntity> findDepartAll(){
        return departmentRepository.findAll();
    }
}
