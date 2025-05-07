package umc.study.repository.CrmRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import umc.study.domain.Crm;
import umc.study.domain.QCrm;
import umc.study.repository.StoreRepository.StoreRepositoryCustom;

import java.util.List;

//실질적으로 사용안됨
@Repository
public class CrmRepositoryImpl  {
        private final JPAQueryFactory jpaQueryFactory;
        private final QCrm crm  = QCrm.crm;
    public CrmRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }
        // 오버라이드는 나중에 서비스단에서 사용한다. @Override
    public List<Crm> dynamicQueryWithBooleanBuilder(String name, Float score) {
        BooleanBuilder predicate = new BooleanBuilder();



        return jpaQueryFactory
                .selectFrom(crm)
                .where(predicate)
                .fetch();


    }

}
