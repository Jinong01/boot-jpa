package kr.it.academy.jpa.dto;

import kr.it.academy.jpa.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter@Setter@Builder
@AllArgsConstructor@NoArgsConstructor
public class BoardDto {

    private Integer seq;
    private String title;
    private String writer;
    private String contents;
    private Integer readCount;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Set<BoardFileDto> boardFiles = new HashSet<>();

    public static BoardDto of(BoardEntity entity){
        Set<BoardFileDto> boardFiles =
                entity.getBoardFiles().stream().map(BoardFileDto::of).collect(Collectors.toSet());

        return BoardDto.builder()
                .seq(entity.getSeq())
                .title(entity.getTitle())
                .writer(entity.getWriter())
                .contents(entity.getContents())
                .readCount(entity.getReadCount())
                .boardFiles(boardFiles)
                .createDate(entity.getCreateDate())
                .build();
    }
}