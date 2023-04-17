package com.lhind.repository.impl;

import com.lhind.configuration.EntityManagerConfiguration;
import com.lhind.model.entity.Role;
import com.lhind.repository.RoleRepository;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class RoleRepositoryImpl implements RoleRepository {

    private final EntityManager entityManager = EntityManagerConfiguration.getEntityManager();

    @Override
    public Optional<Role> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(Role.class, id));
    }

    @Override
    public List<Role> findAll() {
        return null;
    }


    @Override
    public void save(Role role) {
        entityManager.getTransaction().begin();
        if (role.getId() != null) {
            findById(role.getId()).ifPresent(existingEmployee -> {
                role.setRole(role.getRole());
                role.setDescription(role.getDescription());
            });
        } else {
            entityManager.persist(role);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Role role) {
        if (role.getId() != null){
            entityManager.getTransaction().begin();
            findById(role.getId()).ifPresent(entityManager::remove);
            entityManager.getTransaction().commit();
        }
    }
}
