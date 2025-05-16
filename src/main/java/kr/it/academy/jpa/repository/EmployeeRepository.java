package kr.it.academy.jpa.repository;

import kr.it.academy.jpa.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String > {

    @Query("select em from EmployeeEntity em JOIN fetch em.department")
    List<EmployeeEntity> findAll();

    @Modifying //jpql 은 기본적으로 select 전용이라서 상태 변경 할때는 @Modifying 어노테이션 추가
    @Query("delete from EmployeeEntity where emId = :emId")
    //@Query(value = "delete from employee where em_id = :emId", nativeQuery = true)
    int deleteEmployeeById(@Param("emId") String  emId);

}
