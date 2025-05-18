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
    //crm은 사용하는 곳이 없음으로 조건절을 작성하지 않았습니다 그럼에서 이 클래스를 작성한 이유는
        // crm클래스를 레포지토리에 등록함으로 다른 곳에서 사용할 수 있게하려하기 때문입니다.


        return jpaQueryFactory
                .selectFrom(crm)
                .fetch();


    }

}
