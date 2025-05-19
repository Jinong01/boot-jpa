package kr.it.academy.jpa.repository;

import kr.it.academy.jpa.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

    Page<BoardEntity> findByTitle(Pageable pageable, String title);
    /*
        Containing   %a%
        startingWith %a
        endingWith   a%
     */
    Page<BoardEntity> findByTitleContaining(Pageable pageable, String title);

    //or
    Page<BoardEntity> findByTitleContainingOrTitleContaining(Pageable pageable, String title1, String title2);

    //and
    //greaterThan  a > 0
    //greaterThanEqual  a >= 0
    //lessTan  a < 0
    //lessTanEqual  a <= 0
    Page<BoardEntity> findByTitleContainingAndReadCountGreaterThan(String title, int readCount, Pageable pageable);
}