package kr.java.restapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import kr.java.restapi.model.entity.FileEntity;

import java.time.Instant;

@Schema(description = "파일 응답")
public record FileResponse(
        @Schema(description = "파일 ID", example = "1")
        Long id,
        @Schema(description = "원본 파일명", example = "image.png")
        String originalName,
        @Schema(description = "MIME 타입", example = "image/png")
        String contentType,
        @Schema(description = "파일 크기 (bytes)", example = "102400")
        Long fileSize,
        @Schema(description = "업로드 일시", example = "2024-12-18T10:30:00Z")
        Instant createdAt
) {
    public static FileResponse from(FileEntity file) {
        return new FileResponse(
                file.getId(),
                file.getOriginalName(),
                file.getContentType(),
                file.getFileSize(),
                file.getCreatedAt()
        );
    }
}