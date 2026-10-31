package com.tecsup.petclinic;

import com.tecsup.petclinic.entities.PetType;
import com.tecsup.petclinic.services.PetTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PetTypeServiceTest {

    @Autowired
    private PetTypeService petTypeService;

    @Test
    void testFindAll() {
        List<PetType> types = petTypeService.findAll();

        assertNotNull(types);
        assertTrue(types.size() >= 8);
    }

    @Test
    void testFindById() {
        Optional<PetType> type = petTypeService.findById(1);

        assertTrue(type.isPresent());
        assertEquals("cat", type.get().getName());
    }

    @Test
    void testCreate() {
        PetType type = new PetType(
                null,
                "fish",
                "Aquatic animal",
                true,
                "small",
                10,
                "low"
        );

        PetType saved = petTypeService.create(type);

        assertNotNull(saved.getId());
        assertEquals("fish", saved.getName());
    }

    @Test
    void testUpdate() {
        PetType type = new PetType(
                null,
                "cat updated",
                "Updated feline",
                true,
                "small",
                16,
                "medium"
        );

        PetType updated = petTypeService.update(1, type);

        assertEquals(1, updated.getId());
        assertEquals("cat updated", updated.getName());
        assertEquals(16, updated.getAverageLifespan());
    }

    @Test
    void testDelete() {
        PetType type = new PetType(
                null,
                "temporary",
                "Temporary type",
                true,
                "small",
                2,
                "low"
        );

        PetType saved = petTypeService.create(type);
        Integer id = saved.getId();

        petTypeService.delete(id);

        assertFalse(petTypeService.findById(id).isPresent());
    }
}