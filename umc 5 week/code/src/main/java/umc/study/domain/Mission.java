package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.enums.MissionStatus;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private Integer point;

    private LocalDateTime deadline;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;
}
