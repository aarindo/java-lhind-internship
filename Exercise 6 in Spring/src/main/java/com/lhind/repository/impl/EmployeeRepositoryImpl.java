package com.lhind.repository.impl;

import com.lhind.configuration.EntityManagerConfiguration;
import com.lhind.model.entity.Employee;
import com.lhind.repository.EmployeeRepository;
import com.lhind.util.Queries;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final EntityManager entityManager;

    public EmployeeRepositoryImpl() {
        entityManager = EntityManagerConfiguration.getEntityManager();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Employee.class, id));
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> result = entityManager.createQuery(Queries.FIND_ALL_EMPLOYEES, Employee.class);
        return result.getResultList();
    }

    public List<Employee> findAllNamedQuery() {
        TypedQuery<Employee> result = entityManager.createNamedQuery("findByFirstname", Employee.class);
        result.setParameter("uname", "Albania");
        return result.getResultList();
    }

    @Override
    public void save(Employee employee) {
        entityManager.getTransaction().begin();
        if (employee.getId() != null) {
            findById(employee.getId()).ifPresent(existingEmployee -> {
                employee.setFirstName(employee.getFirstName());
                employee.setMiddleName(employee.getMiddleName());
                employee.setLastName(employee.getLastName());
                employee.setEmploymentStatus(employee.getEmploymentStatus());
            });
        } else {
            entityManager.persist(employee);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Employee employee) {
        if (employee.getId() != null) {
            entityManager.getTransaction().begin();
            findById(employee.getId()).ifPresent(entityManager::remove);
            entityManager.getTransaction().commit();
        }
    }

    public Optional<Employee> findByUsername(String username) {
        TypedQuery<Employee> result = entityManager.createQuery(Queries.FIND_EMPLOYEE_BY_USERNAME_METHOD_2, Employee.class);
        result.setParameter("username", username);
        return Optional.ofNullable(result.getSingleResult());
    }

    @Override
    public List<Employee> findByRole(String role) {
        TypedQuery<Employee> result = entityManager.createQuery(Queries.FIND_EMPLOYEE_BY_ROLE, Employee.class);
        result.setParameter("role", role);
        return result.getResultList();    }

}
