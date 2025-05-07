package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAlert is a Querydsl query type for Alert
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAlert extends EntityPathBase<Alert> {

    private static final long serialVersionUID = 1946324378L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAlert alert = new QAlert("alert");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    public final NumberPath<Integer> Alert = createNumber("Alert", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<umc.study.domain.enums.IsConfirmed> isconfirmed = createEnum("isconfirmed", umc.study.domain.enums.IsConfirmed.class);

    public final QMember member;

    public final BooleanPath newMissionAlert = createBoolean("newMissionAlert");

    public final BooleanPath requestedReviewAlert = createBoolean("requestedReviewAlert");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QAlert(String variable) {
        this(Alert.class, forVariable(variable), INITS);
    }

    public QAlert(Path<? extends Alert> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAlert(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAlert(PathMetadata metadata, PathInits inits) {
        this(Alert.class, metadata, inits);
    }

    public QAlert(Class<? extends Alert> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member"), inits.get("member")) : null;
    }

}

