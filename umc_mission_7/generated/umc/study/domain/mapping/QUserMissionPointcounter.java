package umc.study.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserMissionPointcounter is a Querydsl query type for UserMissionPointcounter
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserMissionPointcounter extends EntityPathBase<UserMissionPointcounter> {

    private static final long serialVersionUID = -1540740629L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserMissionPointcounter userMissionPointcounter = new QUserMissionPointcounter("userMissionPointcounter");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    public final NumberPath<Integer> addPoint = createNumber("addPoint", Integer.class);

    public final NumberPath<Integer> completedMission = createNumber("completedMission", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final umc.study.domain.QMember member;

    public final umc.study.domain.QMission mission;

    public final NumberPath<Integer> phonenumberMissionid = createNumber("phonenumberMissionid", Integer.class);

    public final EnumPath<umc.study.domain.enums.Statuses> status = createEnum("status", umc.study.domain.enums.Statuses.class);

    public final NumberPath<Integer> totalPoint = createNumber("totalPoint", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final NumberPath<Integer> usedPoint = createNumber("usedPoint", Integer.class);

    public QUserMissionPointcounter(String variable) {
        this(UserMissionPointcounter.class, forVariable(variable), INITS);
    }

    public QUserMissionPointcounter(Path<? extends UserMissionPointcounter> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserMissionPointcounter(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserMissionPointcounter(PathMetadata metadata, PathInits inits) {
        this(UserMissionPointcounter.class, metadata, inits);
    }

    public QUserMissionPointcounter(Class<? extends UserMissionPointcounter> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new umc.study.domain.QMember(forProperty("member"), inits.get("member")) : null;
        this.mission = inits.isInitialized("mission") ? new umc.study.domain.QMission(forProperty("mission"), inits.get("mission")) : null;
    }

}

