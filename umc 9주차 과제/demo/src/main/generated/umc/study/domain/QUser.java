package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 479029197L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final ListPath<Alarm, QAlarm> alarmList = this.<Alarm, QAlarm>createList("alarmList", Alarm.class, QAlarm.class, PathInits.DIRECT2);

    public final StringPath birth = createString("birth");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final DatePath<java.time.LocalDate> deleted_at = createDate("deleted_at", java.time.LocalDate.class);

    public final StringPath email = createString("email");

    public final EnumPath<umc.study.domain.enums.Gender> gender = createEnum("gender", umc.study.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<umc.study.domain.mapping.MemberMission, umc.study.domain.mapping.QMemberMission> memberMissionList = this.<umc.study.domain.mapping.MemberMission, umc.study.domain.mapping.QMemberMission>createList("memberMissionList", umc.study.domain.mapping.MemberMission.class, umc.study.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final NumberPath<Integer> phoneNumber = createNumber("phoneNumber", Integer.class);

    public final QPoint point;

    public final EnumPath<umc.study.domain.enums.Status> status = createEnum("status", umc.study.domain.enums.Status.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<umc.study.domain.mapping.UserPrefer, umc.study.domain.mapping.QUserPrefer> userPreferList = this.<umc.study.domain.mapping.UserPrefer, umc.study.domain.mapping.QUserPrefer>createList("userPreferList", umc.study.domain.mapping.UserPrefer.class, umc.study.domain.mapping.QUserPrefer.class, PathInits.DIRECT2);

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.point = inits.isInitialized("point") ? new QPoint(forProperty("point"), inits.get("point")) : null;
    }

}

