package kr.it.academy.jpa.repository;

import kr.it.academy.jpa.entity.BoardFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardFileRepository extends JpaRepository<BoardFileEntity, Integer> {
}