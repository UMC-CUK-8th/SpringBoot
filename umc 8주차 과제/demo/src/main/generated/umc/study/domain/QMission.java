package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMission is a Querydsl query type for Mission
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMission extends EntityPathBase<Mission> {

    private static final long serialVersionUID = -200839606L;

    public static final QMission mission = new QMission("mission");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<umc.study.domain.mapping.MemberMission, umc.study.domain.mapping.QMemberMission> memberMissionList = this.<umc.study.domain.mapping.MemberMission, umc.study.domain.mapping.QMemberMission>createList("memberMissionList", umc.study.domain.mapping.MemberMission.class, umc.study.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final StringPath missionName = createString("missionName");

    public final NumberPath<Integer> repair = createNumber("repair", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMission(String variable) {
        super(Mission.class, forVariable(variable));
    }

    public QMission(Path<? extends Mission> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMission(PathMetadata metadata) {
        super(Mission.class, metadata);
    }

}

