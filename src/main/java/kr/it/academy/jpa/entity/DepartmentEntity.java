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

    @JoinColumn(name = "dept_id", referencedColumnName = "dept_id")
    @OneToMany
    private Set<EmployeeEntity> employees = new HashSet<>();

}