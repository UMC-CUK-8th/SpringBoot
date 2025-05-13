package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHelp is a Querydsl query type for Help
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHelp extends EntityPathBase<Help> {

    private static final long serialVersionUID = 478628675L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHelp help1 = new QHelp("help1");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath help = createString("help");

    public final NumberPath<Integer> helpId = createNumber("helpId", Integer.class);

    public final QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QHelp(String variable) {
        this(Help.class, forVariable(variable), INITS);
    }

    public QHelp(Path<? extends Help> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHelp(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHelp(PathMetadata metadata, PathInits inits) {
        this(Help.class, metadata, inits);
    }

    public QHelp(Class<? extends Help> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member"), inits.get("member")) : null;
    }

}

