package org.springframework.samples.petclinic.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VetControllerTest {
    Collection<Vet> vets;

    @Mock
    ClinicService clinicService;

    @InjectMocks
    VetController vetController;

    @BeforeEach
    void setUp() {
        Vet vet1 = new Vet();
        vet1.setFirstName("Susan");
        Vet vet2 = new Vet();
        vet2.setFirstName("Bob");

        vets = Arrays.asList(vet1, vet2);

        when(clinicService.findVets()).thenReturn(vets);
    }

    @Test
    void showVetList() {
        Map<String, Object> model = new HashMap<>();

        String returnValue = vetController.showVetList(model);

        assertThat(returnValue).isEqualTo("vets/vetList");
        assertThat(model).isNotEmpty().hasSize(1);
        assertThat(model).containsKey("vets");
//        assertThat(model).extracting("vets").hasSize(1);
    }

    @Test
    void showResourcesVetList() {
        Vets vets = vetController.showResourcesVetList();

        assertThat(vets.getVetList()).hasSize(2);
//        assertThat(vets.getVetList()).con
    }
}