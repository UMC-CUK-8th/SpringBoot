<<<<<<< HEAD
package umc.study.domain;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import umc.study.domain.common.BaseEntity;

public class food_category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
=======
package umc.study.domain;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import umc.study.domain.common.BaseEntity;

public class food_category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
>>>>>>> 58429fcd7179c341c9b1ac4cf4c68aa9807ca3f3
