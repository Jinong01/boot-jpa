package kr.it.academy.jpa.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.it.academy.jpa.dto.EmployeeDto;
import kr.it.academy.jpa.entity.DepartmentEntity;
import kr.it.academy.jpa.entity.EmployeeEntity;
import kr.it.academy.jpa.repository.DepartmentRepository;
import kr.it.academy.jpa.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @PersistenceContext
    private EntityManager em;

    public List<EmployeeDto> findAll() {

        List<EmployeeDto> list = employeeRepository.findAll().stream()
                                .map(EmployeeDto::of).toList();

        return list;
    }

    public List<EmployeeDto> findAll2() {

        List<EmployeeEntity> emList =
                em.createQuery("select e from EmployeeEntity e", EmployeeEntity.class).getResultList();

        List<EmployeeDto> list = emList.stream().map(EmployeeDto::of).collect(Collectors.toList());


        return list;
    }

    public List<EmployeeDto> findAll3() {
        String sql = """
                select 
                    em.em_id,
                    em.my_name,
                    dp.dept_id,
                    dp.dept_name,
                    dp.floor
                from employee em
                join department dp on em.dept_id = dp.dept_id
                """;
        List<Object[]> emList =
                em.createNativeQuery(sql).getResultList();

        List<EmployeeDto> list = emList.stream()
                                .map(obj ->
                                     EmployeeDto.builder()
                                            .emId(obj[0].toString())
                                            .myName(obj[1].toString())
                                            .deptId(obj[2].toString())
                                            .deptName(obj[3].toString())
                                            .floor(obj[4].toString())
                                            .build()
                                ).collect(Collectors.toList());


        return list;
    }

    public Map<String, Object> save() {
        // 새로운 부서를 만들면서 새로운 직원을 넣을땐 > 부서를 먼저 만들고
        DepartmentEntity department = new DepartmentEntity();
        department.setDeptId("dept201");
        department.setDeptName("특수부");
        department.setFloor("4");

        // 직원들 만들고
        EmployeeEntity employee = new EmployeeEntity();
        employee.setEmId("em107");
        employee.setMyName("구본후");

        //부서에 직원 정보 넣어주기
        department.addEmployee(employee);

        departmentRepository.save(department);

        Map<String, Object> result = new HashMap<>();
        result.put("resultMsg", "등록 성공");
        return result;
    }

    public int delete(String emId) {
        return employeeRepository.deleteEmployeeById(emId);
    }
}
