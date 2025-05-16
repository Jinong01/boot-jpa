package kr.it.academy.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "writer", nullable = false, length = 50)
    private String writer;

    @Lob
    @Column(name = "contents", nullable = false)
    private String contents;

    @ColumnDefault("0")
    @Column(name = "read_count")
    private Integer readCount;

    @ColumnDefault("current_timestamp()")
    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "update_date")
    private Instant updateDate;

    @OneToMany(mappedBy = "boardSeq")
    private Set<BoardFileEntity> boardFiles = new LinkedHashSet<>();

}