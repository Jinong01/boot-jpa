package kr.it.academy.jpa.dto;

import kr.it.academy.jpa.entity.DepartmentEntity;
import lombok.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * DTO for {@link kr.it.academy.jpa.entity.DepartmentEntity}
 */
@Getter@Setter@Builder
@AllArgsConstructor@RequiredArgsConstructor
public class DepartmentDto implements Serializable {
    private String deptId;
    private String deptName;
    private String floor;
    private Set<EmployeeDto> employees = new HashSet<>();

    public static DepartmentDto of (DepartmentEntity entity) {
        Set<EmployeeDto> employees = entity.getEmployees()
                .stream()
                .map(EmployeeDto::of)
                .collect(Collectors.toSet());

        return DepartmentDto.builder()
                .deptId(entity.getDeptId())
                .deptName(entity.getDeptName())
                .floor(entity.getFloor())
                .employees(employees)
                .build();
    }

    // 부서 등록/수정 할 때 쓰이는거라 직원정보 필요없음
    public static DepartmentEntity to (DepartmentDto dto) {
        DepartmentEntity entity = new DepartmentEntity();
        entity.setDeptId(dto.getDeptId());
        entity.setDeptName(dto.getDeptName());
        entity.setFloor(dto.getFloor());
        return entity;
    }
}