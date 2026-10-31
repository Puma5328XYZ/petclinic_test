package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.PetType;

import java.util.List;
import java.util.Optional;

public interface PetTypeService {

    List<PetType> findAll();

    Optional<PetType> findById(Integer id);

    PetType create(PetType petType);

    PetType update(Integer id, PetType petType);

    void delete(Integer id);
}