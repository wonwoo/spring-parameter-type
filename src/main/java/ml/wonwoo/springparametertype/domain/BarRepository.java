package ml.wonwoo.springparametertype.domain;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;

public interface BarRepository extends QuerydslBinderCustomizer<QBar>, JpaRepository<Bar, Long>, QuerydslPredicateExecutor<Bar> {

    @Override
    default void customize(QuerydslBindings bindings, QBar user) {
        bindings.bind(String.class)
            .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }
}
