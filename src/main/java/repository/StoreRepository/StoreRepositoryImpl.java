package repository.StoreRepository;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.example.study.domain.QStore;
import org.example.study.domain.Store;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final QStore store = QStore.store;

    @Override
    public List<Store> dynamicQueryWithBooleanBuilder(String name, String type) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (name != null) {
            predicate.and(store.storename.eq(name));
        }

        if (type != null) {
            predicate.and(store.storetype.eq(type));
        }

        return jpaQueryFactory
                .selectFrom(store)
                .where(predicate)
                .fetch();
    }
}