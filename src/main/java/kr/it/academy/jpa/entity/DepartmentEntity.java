package kr.it.academy.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@BatchSize(size = 5)
@Table(name = "department")
public class DepartmentEntity {
    @Id
    @Column(name = "dept_Id", nullable = false, length = 100)
    private String deptId;

    @Column(name = "dept_name", nullable = false, length = 100)
    private String deptName;

    @Column(name = "floor", nullable = false, length = 10)
    private String floor;

//    @JoinColumn(name = "dept_id", referencedColumnName = "dept_id") --> 이렇게하면 순환참조 걸림
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true) // 주체가 변화가 있으면 그 안에 있는 employees 도 변화가 생긴다
    private Set<EmployeeEntity> employees = new HashSet<>();

    public void addEmployee(EmployeeEntity employee) {
        employees.add(employee);
        //저장할 직원의 부서는 자기자신이 된다.
        employee.setDepartment(this);
    }
}