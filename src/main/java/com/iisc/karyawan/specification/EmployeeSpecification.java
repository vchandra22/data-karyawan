package com.iisc.karyawan.specification;

import com.iisc.karyawan.dto.request.SearchEmployeeRequest;
import com.iisc.karyawan.entity.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSpecification {
    public static Specification<Employee> getSpecification(SearchEmployeeRequest searchEmployeeRequest) {
        return new Specification<Employee>() {

            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (StringUtils.hasText(searchEmployeeRequest.getFullName())) {
                    predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("fullName")), "%" + searchEmployeeRequest.getFullName().toLowerCase() + "%"));
                }

                if (StringUtils.hasText(searchEmployeeRequest.getAddress())) {
                    predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("address")), searchEmployeeRequest.getAddress().toLowerCase() + "%"));
                }

                if (StringUtils.hasText(searchEmployeeRequest.getNationality())) {
                    predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("nationality")), searchEmployeeRequest.getNationality().toLowerCase() + "%"));
                }

                if (!predicates.isEmpty()) {
                    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}
