package ml.wonwoo.springparametertype.data;

import com.querydsl.core.types.Predicate;
import ml.wonwoo.springparametertype.domain.Bar;
import ml.wonwoo.springparametertype.domain.BarRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringDataController {

    private final BarRepository barRepository;

    public SpringDataController(BarRepository barRepository) {
        this.barRepository = barRepository;
    }

    @GetMapping("/dsl")
    public Iterable<Bar> dsl(@QuerydslPredicate(root = Bar.class) Predicate predicate) {
        return barRepository.findAll(predicate);
    }

    @GetMapping("/page")
    public String page(@PageableDefault(size = 100, page = 1, sort = "id", direction = Direction.ASC) Pageable pageable, Sort sort) {
        return "page";
    }

    @PostMapping("/payload")
    public String payload(@RequestBody PayLoadExample payLoad) {
        return payLoad.getName();
    }

}

