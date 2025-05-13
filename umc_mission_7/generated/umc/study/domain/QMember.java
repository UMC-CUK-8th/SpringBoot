package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 543821340L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMember member = new QMember("member1");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final DatePath<java.time.LocalDate> birth = createDate("birth", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final ListPath<Crm, QCrm> Crm = this.<Crm, QCrm>createList("Crm", Crm.class, QCrm.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> deletedAt = createDateTime("deletedAt", java.time.LocalDateTime.class);

    public final StringPath email = createString("email");

    public final EnumPath<umc.study.domain.enums.Gender> gender = createEnum("gender", umc.study.domain.enums.Gender.class);

    public final BooleanPath isActive = createBoolean("isActive");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final NumberPath<Integer> phoneNumber = createNumber("phoneNumber", Integer.class);

    public final QPreferences Preferences;

    public final ListPath<umc.study.domain.mapping.Review, umc.study.domain.mapping.QReview> Review = this.<umc.study.domain.mapping.Review, umc.study.domain.mapping.QReview>createList("Review", umc.study.domain.mapping.Review.class, umc.study.domain.mapping.QReview.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<umc.study.domain.mapping.UserMissionPointcounter, umc.study.domain.mapping.QUserMissionPointcounter> UserMissionPointcounter = this.<umc.study.domain.mapping.UserMissionPointcounter, umc.study.domain.mapping.QUserMissionPointcounter>createList("UserMissionPointcounter", umc.study.domain.mapping.UserMissionPointcounter.class, umc.study.domain.mapping.QUserMissionPointcounter.class, PathInits.DIRECT2);

    public QMember(String variable) {
        this(Member.class, forVariable(variable), INITS);
    }

    public QMember(Path<? extends Member> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMember(PathMetadata metadata, PathInits inits) {
        this(Member.class, metadata, inits);
    }

    public QMember(Class<? extends Member> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.Preferences = inits.isInitialized("Preferences") ? new QPreferences(forProperty("Preferences")) : null;
    }

}

