package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStoreInfo is a Querydsl query type for StoreInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreInfo extends EntityPathBase<StoreInfo> {

    private static final long serialVersionUID = 714419821L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoreInfo storeInfo = new QStoreInfo("storeInfo");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath foodInfo = createString("foodInfo");

    public final StringPath foodName = createString("foodName");

    public final ArrayPath<byte[], Byte> foodPicture = createArray("foodPicture", byte[].class);

    public final QOwnerList OwnerList;

    public final NumberPath<Integer> storeId = createNumber("storeId", Integer.class);

    public final StringPath storeName = createString("storeName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QStoreInfo(String variable) {
        this(StoreInfo.class, forVariable(variable), INITS);
    }

    public QStoreInfo(Path<? extends StoreInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStoreInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStoreInfo(PathMetadata metadata, PathInits inits) {
        this(StoreInfo.class, metadata, inits);
    }

    public QStoreInfo(Class<? extends StoreInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.OwnerList = inits.isInitialized("OwnerList") ? new QOwnerList(forProperty("OwnerList")) : null;
    }

}

