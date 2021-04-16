package io.csrohit.jpasearchpageable;

import org.hibernate.NonUniqueResultException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findByFirstName(String firstName) throws NonUniqueResultException;
    public Page<Employee> findByEmailContaining(Pageable pageable, String email);
    public Page<Employee> findByFirstNameContaining(Pageable pageable, String firstName);
    public Page<Employee> findByLastNameContaining(Pageable pageable, String lastName);
}
