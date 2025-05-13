package Concurrency_Project.Hello_Concurrency.post.entity;

import Concurrency_Project.Hello_Concurrency.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50) // 최소 사이즈 검사는 프론트 or Bean Validation?
    private String title;

    @Column(nullable = false)
    private String body;
}
