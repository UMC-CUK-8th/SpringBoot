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

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMission mission = new QMission("mission");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath missionDetail = createString("missionDetail");

    public final NumberPath<Long> missionId = createNumber("missionId", Long.class);

    public final StringPath missionName = createString("missionName");

    public final ListPath<umc.study.domain.mapping.Review, umc.study.domain.mapping.QReview> reviewList = this.<umc.study.domain.mapping.Review, umc.study.domain.mapping.QReview>createList("reviewList", umc.study.domain.mapping.Review.class, umc.study.domain.mapping.QReview.class, PathInits.DIRECT2);

    public final NumberPath<Integer> reward = createNumber("reward", Integer.class);

    public final QStoreInfo storeInfo;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<umc.study.domain.mapping.UserMissionPointcounter, umc.study.domain.mapping.QUserMissionPointcounter> userMissionPointcounter = this.<umc.study.domain.mapping.UserMissionPointcounter, umc.study.domain.mapping.QUserMissionPointcounter>createList("userMissionPointcounter", umc.study.domain.mapping.UserMissionPointcounter.class, umc.study.domain.mapping.QUserMissionPointcounter.class, PathInits.DIRECT2);

    public QMission(String variable) {
        this(Mission.class, forVariable(variable), INITS);
    }

    public QMission(Path<? extends Mission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMission(PathMetadata metadata, PathInits inits) {
        this(Mission.class, metadata, inits);
    }

    public QMission(Class<? extends Mission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.storeInfo = inits.isInitialized("storeInfo") ? new QStoreInfo(forProperty("storeInfo"), inits.get("storeInfo")) : null;
    }

}

