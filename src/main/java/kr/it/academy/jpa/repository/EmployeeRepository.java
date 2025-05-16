package kr.it.academy.jpa.repository;

import kr.it.academy.jpa.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String > {

    @Query("select em from EmployeeEntity em JOIN fetch em.department")
    List<EmployeeEntity> findAll();
}
