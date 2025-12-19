package kr.java.restapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * 상품 수정 요청 DTO (PUT: 전체 수정)
 */
@Schema(description = "상품 수정 요청")
public record ItemUpdateRequest(

        @Schema(description = "상품명", example = "유선 키보드", maxLength = 100)
        @NotBlank(message = "상품명은 필수입니다")
        @Size(max = 100, message = "상품명은 100자 이하로 입력해주세요")
        String name,

        @Schema(description = "가격 (원)", example = "25000", minimum = "0")
        @NotNull(message = "가격은 필수입니다")
        @Min(value = 0, message = "가격은 0 이상이어야 합니다")
        Integer price,

        @Schema(description = "상품 설명", example = "USB-C 타입", maxLength = 500)
        @Size(max = 500, message = "설명은 500자 이하로 입력해주세요")
        String description
) {
}