package io.csrohit.jpasearchpageable;

import org.hibernate.NonUniqueResultException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findByFirstName(String firstName) throws NonUniqueResultException;
    public List<Employee> findByEmailContaining(String email);
    public List<Employee> findByFirstNameContaining(String firstName);
    public List<Employee> findByLastNameContaining(String lastName);
}
