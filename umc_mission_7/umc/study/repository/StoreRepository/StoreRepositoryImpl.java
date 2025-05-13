package umc.study.repository.StoreRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.StoreInfo;
import umc.study.domain.QStoreInfo;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final QStoreInfo storeInfo  = QStoreInfo.storeInfo;

    @Override
    public List<StoreInfo> dynamicQueryWithBooleanBuilder(String name, Float score) {
        BooleanBuilder predicate = new BooleanBuilder();

        //umc 6주차 워크북 내용 참조로써 작성함
        if (name != null) {
            predicate.and(storeInfo.storeName.eq(name));
        }

        return jpaQueryFactory
                .selectFrom(storeInfo)
                .where(predicate)
                .fetch();
    }
}