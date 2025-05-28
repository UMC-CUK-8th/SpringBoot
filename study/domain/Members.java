package umcstudy.study.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umcstudy.study.domain.Point;
import umcstudy.study.domain.common.BaseEntity;
import umcstudy.study.domain.enums.memberStatus;
import umcstudy.study.domain.mapping.Reviews;
import umcstudy.study.domain.mapping.Usermissions;
import umcstudy.study.domain.mapping.locationbonusmission;

import java.util.ArrayList;
import java.util.List;
@DynamicUpdate
@DynamicInsert
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Members extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 20)
    private String memID;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false, length = 60)
    private String Email;

    @Column(nullable = false, length = 20)
    private String foodprefer;

    @Column(nullable = false, length = 40)
    private String address;

    private Integer birth;

    @Column(nullable = false, length = 20)
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private memberStatus status;

    @OneToMany(mappedBy = "members", cascade = CascadeType.ALL)
    private List<Reviews> memberRevewList = new ArrayList<>();

    @OneToMany(mappedBy = "members", cascade = CascadeType.ALL)
    private List<Usermissions> usermissionsList = new ArrayList<>();

    @OneToMany(mappedBy = "members", cascade = CascadeType.ALL)
    private List<locationbonusmission> locationbonusmissions = new ArrayList<>();

    @OneToMany(mappedBy = "members", cascade = CascadeType.ALL)
    private List<Point> points = new ArrayList<>();

    private int getNowPointFromPoints() {
        if (points == null || points.isEmpty()) {
            return 0;
        }
        return points.get(0).getNowpoint();
    }
    public String toString() {

        return "Members{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", memID='" + memID + '\'' +
                ", Email='" + Email + '\'' +
                ", nowPoint='" + getNowPointFromPoints() + '\'' +
                '}';


    }
    }