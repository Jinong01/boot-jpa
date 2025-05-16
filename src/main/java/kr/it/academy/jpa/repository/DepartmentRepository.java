package kr.it.academy.jpa.repository;

import kr.it.academy.jpa.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, String > {
}
