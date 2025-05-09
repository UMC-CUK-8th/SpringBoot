package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPersonalPreference is a Querydsl query type for PersonalPreference
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPersonalPreference extends EntityPathBase<PersonalPreference> {

    private static final long serialVersionUID = -1301135427L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPersonalPreference personalPreference = new QPersonalPreference("personalPreference");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath notPreferred = createString("notPreferred");

    public final StringPath preferred = createString("preferred");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final QUser user;

    public QPersonalPreference(String variable) {
        this(PersonalPreference.class, forVariable(variable), INITS);
    }

    public QPersonalPreference(Path<? extends PersonalPreference> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPersonalPreference(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPersonalPreference(PathMetadata metadata, PathInits inits) {
        this(PersonalPreference.class, metadata, inits);
    }

    public QPersonalPreference(Class<? extends PersonalPreference> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

