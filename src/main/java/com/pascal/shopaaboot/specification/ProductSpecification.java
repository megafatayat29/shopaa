package com.pascal.shopaaboot.specification;

import com.pascal.shopaaboot.dto.ProductSearchDto;
import com.pascal.shopaaboot.entity.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecification {

    public static Specification<Product> getSpecification(ProductSearchDto productSearchDto) {
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (!(productSearchDto.getName()==null)) {
                    Predicate byNamePredicate = criteriaBuilder.like(root.get("name"), "%"+productSearchDto.getName()+"%");
                    predicates.add(byNamePredicate);
                }
                if (!(productSearchDto.getDescription()==null)) {
                    Predicate byDescriptionPredicate = criteriaBuilder.like(root.get("description"), "%"+productSearchDto.getDescription()+"%");
                    predicates.add(byDescriptionPredicate);
                }
                if (!(productSearchDto.getMinPrice()==null)) {
                    Predicate byMinPricePredicate = criteriaBuilder.greaterThanOrEqualTo(root.get("price"), productSearchDto.getMinPrice());
                    predicates.add(byMinPricePredicate);
                }
                if (!(productSearchDto.getMaxPrice()==null)) {
                    Predicate byMaxPricePredicate = criteriaBuilder.lessThanOrEqualTo(root.get("price"), productSearchDto.getMaxPrice());
                    predicates.add(byMaxPricePredicate);
                }
                if (!(productSearchDto.getStock()==null)) {
                    Predicate byStockPredicate = criteriaBuilder.equal(root.get("stock"), productSearchDto.getStock());
                    predicates.add(byStockPredicate);
                }
                Predicate [] arrayPredicates = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrayPredicates);
            }
        };
    }
}
