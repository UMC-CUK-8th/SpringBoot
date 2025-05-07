package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Crm extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cmrId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phoneNumber")
    private Member member;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Lob
    private byte[] crmPicture;


}
