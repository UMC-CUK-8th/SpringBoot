package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPreferences is a Querydsl query type for Preferences
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPreferences extends EntityPathBase<Preferences> {

    private static final long serialVersionUID = -821871434L;

    public static final QPreferences preferences = new QPreferences("preferences");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<umc.study.domain.enums.PreferdFood> preferedFood = createEnum("preferedFood", umc.study.domain.enums.PreferdFood.class);

    public final NumberPath<Integer> preId = createNumber("preId", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QPreferences(String variable) {
        super(Preferences.class, forVariable(variable));
    }

    public QPreferences(Path<? extends Preferences> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPreferences(PathMetadata metadata) {
        super(Preferences.class, metadata);
    }

}

