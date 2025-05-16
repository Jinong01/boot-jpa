package kr.it.academy.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @Column(name = "em_id", nullable = false, length = 100)
    private String emId;

    @Column(name = "my_name", nullable = false, length = 100)
    private String myName;

    @JoinColumn(name = "dept_id")
    @ManyToOne(fetch = FetchType.EAGER)
    DepartmentEntity department;
    //기본키가 조인됨

}