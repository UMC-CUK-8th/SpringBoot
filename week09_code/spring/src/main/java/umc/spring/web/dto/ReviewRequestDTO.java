package umc.spring.web.dto;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.validation.annotation.ExistStores;
import umc.spring.validation.annotation.ExistUsers;

import java.time.LocalDate;

public class ReviewRequestDTO {


    @Getter
    public static class JoinDTO {

        @NotBlank
        String content;

        @NotNull
        LocalDate writingDate;

        @NotNull
        Float score;

        @ExistStores
        Long store;

        @ExistUsers
        Long user;

    }
}
/*
{
        "content": "그럭저럭 맛있네요",
        "witingDate": "2001-01-10",
        "score": "4.3",
        "store": 1,
        "user": "1"
        }
*/
