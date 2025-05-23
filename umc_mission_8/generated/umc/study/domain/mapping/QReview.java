package umc.study.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReview is a Querydsl query type for Review
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReview extends EntityPathBase<Review> {

    private static final long serialVersionUID = 670802426L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReview review = new QReview("review");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath description = createString("description");

    public final umc.study.domain.QMember member;

    public final umc.study.domain.QMission mission;

    public final StringPath reply = createString("reply");

    public final NumberPath<Long> reviewId = createNumber("reviewId", Long.class);

    public final ArrayPath<byte[], Byte> reviewPicture = createArray("reviewPicture", byte[].class);

    public final NumberPath<Integer> score = createNumber("score", Integer.class);

    public final umc.study.domain.QStoreInfo storeInfo;

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QReview(String variable) {
        this(Review.class, forVariable(variable), INITS);
    }

    public QReview(Path<? extends Review> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReview(PathMetadata metadata, PathInits inits) {
        this(Review.class, metadata, inits);
    }

    public QReview(Class<? extends Review> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new umc.study.domain.QMember(forProperty("member")) : null;
        this.mission = inits.isInitialized("mission") ? new umc.study.domain.QMission(forProperty("mission"), inits.get("mission")) : null;
        this.storeInfo = inits.isInitialized("storeInfo") ? new umc.study.domain.QStoreInfo(forProperty("storeInfo"), inits.get("storeInfo")) : null;
    }

}

