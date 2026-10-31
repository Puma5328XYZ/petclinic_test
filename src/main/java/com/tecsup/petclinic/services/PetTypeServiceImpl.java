package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.PetType;
import com.tecsup.petclinic.repositories.PetTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetTypeServiceImpl implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeServiceImpl(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public List<PetType> findAll() {
        return petTypeRepository.findAll();
    }

    @Override
    public Optional<PetType> findById(Integer id) {
        return petTypeRepository.findById(id);
    }

    @Override
    public PetType create(PetType petType) {
        petType.setId(null);
        return petTypeRepository.save(petType);
    }

    @Override
    public PetType update(Integer id, PetType petType) {
        PetType existing = petTypeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Tipo de mascota no encontrado: " + id));

        existing.setName(petType.getName());
        existing.setDescription(petType.getDescription());
        existing.setActive(petType.getActive());
        existing.setSizeCategory(petType.getSizeCategory());
        existing.setAverageLifespan(petType.getAverageLifespan());
        existing.setCareLevel(petType.getCareLevel());

        return petTypeRepository.save(existing);
    }

    @Override
    public void delete(Integer id) {
        if (!petTypeRepository.existsById(id)) {
            throw new RuntimeException(
                    "Tipo de mascota no encontrado: " + id);
        }

        petTypeRepository.deleteById(id);
    }
}