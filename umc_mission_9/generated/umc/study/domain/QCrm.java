package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCrm is a Querydsl query type for Crm
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCrm extends EntityPathBase<Crm> {

    private static final long serialVersionUID = 2093645212L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCrm crm = new QCrm("crm");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    public final NumberPath<Long> cmrId = createNumber("cmrId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final ArrayPath<byte[], Byte> crmPicture = createArray("crmPicture", byte[].class);

    public final StringPath description = createString("description");

    public final QMember member;

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QCrm(String variable) {
        this(Crm.class, forVariable(variable), INITS);
    }

    public QCrm(Path<? extends Crm> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCrm(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCrm(PathMetadata metadata, PathInits inits) {
        this(Crm.class, metadata, inits);
    }

    public QCrm(Class<? extends Crm> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

