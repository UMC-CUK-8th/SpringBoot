package umc.study.domain.mapping;


import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Preferences;
import umc.study.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberPreferId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pre_id")
    private Preferences preferences;

    public void setMember(Member member){//해당 데이터타입으로 바꾸기 위한 연관관계 설정
        if(this.member != null)
            member.getMemberPreferList().remove(this);//바뀌어지는 데이터 타입
        this.member = member;
        member.getMemberPreferList().add(this);
    }

    public void setPreferences(Preferences preferences){
        this.preferences = preferences;
    }
}
