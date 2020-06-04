package org.springframework.samples.petclinic.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.repository.PetRepository;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClinicServiceImplTest {
    private PetType cat;
    private PetType dog;
    private PetType snake;

    @Mock
    private PetRepository petRepository;

    @InjectMocks
    private ClinicServiceImpl clinicService;

    @BeforeEach
    void setUp() {
        cat = new PetType();
        cat.setName("cat");
        dog = new PetType();
        dog.setName("dog");
        snake = new PetType();
        snake.setName("snake");
    }

    @Test
    void findPetTypes() {
        when(petRepository.findPetTypes()).thenReturn(Arrays.asList(cat, dog, snake));

        Collection<PetType> petTypes = clinicService.findPetTypes();

        assertThat(petTypes).hasSize(3);
    }
}