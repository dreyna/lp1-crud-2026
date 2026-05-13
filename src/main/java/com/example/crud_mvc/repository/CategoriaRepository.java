package com.example.crud_mvc.repository;

import com.example.crud_mvc.model.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria,Long> {
    boolean existsByNombre(String nombre);
}
