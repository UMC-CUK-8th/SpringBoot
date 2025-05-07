package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOwnerList is a Querydsl query type for OwnerList
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOwnerList extends EntityPathBase<OwnerList> {

    private static final long serialVersionUID = -959825105L;

    public static final QOwnerList ownerList = new QOwnerList("ownerList");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Integer> ownerNum = createNumber("ownerNum", Integer.class);

    public final ListPath<StoreInfo, QStoreInfo> StoreInfo = this.<StoreInfo, QStoreInfo>createList("StoreInfo", StoreInfo.class, QStoreInfo.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QOwnerList(String variable) {
        super(OwnerList.class, forVariable(variable));
    }

    public QOwnerList(Path<? extends OwnerList> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOwnerList(PathMetadata metadata) {
        super(OwnerList.class, metadata);
    }

}

