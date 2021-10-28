package com.pascal.shopaaboot.specification;

import com.pascal.shopaaboot.dto.CustomerSearchDto;
import com.pascal.shopaaboot.entity.Customer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CustomerSpecification {

    public static Specification<Customer> getSpecification(CustomerSearchDto customerSearchDto) {
        return new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (!(customerSearchDto.getCompleteName()==null)) {
                    Predicate byCompleteNamePredicate = criteriaBuilder.like(root.get("completeName"), "%"+customerSearchDto.getCompleteName()+"%");
                    predicates.add(byCompleteNamePredicate);
                }
                if (!(customerSearchDto.getUsername()==null)) {
                    Predicate byUsernamePredicate = criteriaBuilder.like(root.get("username"), "%"+customerSearchDto.getUsername()+"%");
                    predicates.add(byUsernamePredicate);
                }
                if (!(customerSearchDto.getBirthDate()==null)) {
                    Predicate byBirthDatePredicate = criteriaBuilder.equal(root.get("birthDate"), customerSearchDto.getBirthDate());
                    predicates.add(byBirthDatePredicate);
                }
                if (!(customerSearchDto.getPhone()==null)) {
                    Predicate byPhonePredicate = criteriaBuilder.like(root.get("phone"), "%"+customerSearchDto.getPhone()+"%");
                    predicates.add(byPhonePredicate);
                }
                if (!(customerSearchDto.getEmail()==null)) {
                    Predicate byEmailPredicate = criteriaBuilder.like(root.get("email"), "%"+customerSearchDto.getEmail()+"%");
                    predicates.add(byEmailPredicate);
                }
                if (!(customerSearchDto.getGender()==null)) {
                    Predicate byGenderPredicate = criteriaBuilder.like(root.get("gender"), "%"+customerSearchDto.getGender()+"%");
                    predicates.add(byGenderPredicate);
                }
                Predicate [] arrayPredicates = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrayPredicates);
            }
        };
    }
}
