package com.lhind.repository.impl;

import com.lhind.configuration.EntityManagerConfiguration;
import com.lhind.model.entity.Employee;
import com.lhind.model.entity.EmployeeDetails;
import com.lhind.repository.EmployeeDetailsRepository;
import com.lhind.repository.Repository;
import com.lhind.util.Queries;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class EmoployeeDetailsRepositoryImpl implements EmployeeDetailsRepository {

    private final EntityManager entityManager;

    public EmoployeeDetailsRepositoryImpl() {
        entityManager = EntityManagerConfiguration.getEntityManager();
    }

    @Override
    public Optional<EmployeeDetails> findById(Long id) {
        return Optional.ofNullable(entityManager.find(EmployeeDetails.class,id));
    }

    @Override
    public List<EmployeeDetails> findAll(){
        TypedQuery<EmployeeDetails> result = entityManager.createQuery(Queries.FIND_ALL_EMPLOYEE_DETAILS, EmployeeDetails.class);
        return result.getResultList();
    }

    @Override
    public void save(EmployeeDetails employeeDetails) {
        entityManager.getTransaction().begin();
        if (employeeDetails.getId() != null) {
            findById(employeeDetails.getId()).ifPresent(existingEmployee -> {
                employeeDetails.setEmail(employeeDetails.getEmail());
                employeeDetails.setPhoneNumber(employeeDetails.getPhoneNumber());
                employeeDetails.setEmploymentDate(employeeDetails.getEmploymentDate());
            });
        } else {
            entityManager.persist(employeeDetails);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(EmployeeDetails employeeDetails) {
        if (employeeDetails.getId() != null) {
            entityManager.getTransaction().begin();
            findById(employeeDetails.getId()).ifPresent(entityManager::remove);
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public Optional<EmployeeDetails> findByEmail(String email){
        TypedQuery<EmployeeDetails> result = entityManager.createQuery(Queries.FIND_EMPLOYEE_DETAILS_BY_EMAIL, EmployeeDetails.class);
        result.setParameter("email", email);
        return Optional.ofNullable(result.getSingleResult());
    }
}
