package kr.it.academy.jpa.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter@Setter@Builder
@AllArgsConstructor@NoArgsConstructor
public class BoardDto {

    private Integer id;
    private String title;
    private String writer;
    private String contents;
    private Integer readCount;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Set<BoardFileDto> boardFiles = new HashSet<>();

    @Getter@Setter@Builder
    @AllArgsConstructor@NoArgsConstructor
    public class BoardFileDto{
        private Integer id;
        private String fileName;
        private String storedFileName;
        private String filePath;
        private LocalDateTime createDate;
    }

}