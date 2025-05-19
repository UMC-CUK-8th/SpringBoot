package umc.study.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserPrefer is a Querydsl query type for UserPrefer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserPrefer extends EntityPathBase<UserPrefer> {

    private static final long serialVersionUID = 1742196573L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserPrefer userPrefer = new QUserPrefer("userPrefer");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final umc.study.domain.QFoodCategory foodCategory;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath notPreferred = createString("notPreferred");

    public final StringPath preferred = createString("preferred");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final umc.study.domain.QUser user;

    public QUserPrefer(String variable) {
        this(UserPrefer.class, forVariable(variable), INITS);
    }

    public QUserPrefer(Path<? extends UserPrefer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserPrefer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserPrefer(PathMetadata metadata, PathInits inits) {
        this(UserPrefer.class, metadata, inits);
    }

    public QUserPrefer(Class<? extends UserPrefer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodCategory = inits.isInitialized("foodCategory") ? new umc.study.domain.QFoodCategory(forProperty("foodCategory")) : null;
        this.user = inits.isInitialized("user") ? new umc.study.domain.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

