package kr.it.academy.jpa.dto;

import kr.it.academy.jpa.entity.EmployeeEntity;
import lombok.*;
import java.io.Serializable;

/**
 * DTO for {@link kr.it.academy.jpa.entity.EmployeeEntity}
 */
@Setter@Getter@Builder
@AllArgsConstructor@NoArgsConstructor
public class EmployeeDto implements Serializable {
    private String emId;
    private String myName;
    private String deptId;
    private String deptName;
    private String floor;

    public static EmployeeDto of (EmployeeEntity entity) {

        return EmployeeDto.builder()
                .emId(entity.getEmId())
                .myName(entity.getMyName())
                .deptId(entity.getDepartment().getDeptId())
                .deptName(entity.getDepartment().getDeptName())
                .floor(entity.getDepartment().getFloor())
                .build();
    }

    public static EmployeeEntity to (EmployeeDto dto) {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setEmId(dto.getEmId());
        entity.setMyName(dto.getMyName());
        return entity;
    }
}