package kr.it.academy.jpa.dto;

import kr.it.academy.jpa.entity.BoardFileEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter@Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class BoardFileDto{
    private Integer seq;
    private String fileName;
    private String storedFileName;
    private String filePath;
    private LocalDateTime createDate;

    public static BoardFileDto of (BoardFileEntity entity){
        return BoardFileDto.builder()
                .seq(entity.getSeq())
                .fileName(entity.getFileName())
                .storedFileName(entity.getStoredFileName())
                .filePath(entity.getFilePath())
                .createDate(entity.getCreateDate())
                .build();
    }
}