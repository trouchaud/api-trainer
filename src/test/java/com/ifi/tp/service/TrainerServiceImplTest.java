package com.ifi.tp.service;

import com.ifi.tp.bo.Trainer;
import com.ifi.tp.repository.TrainerRepository;
import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

class TrainerServiceImplTest {

    @Mock
    TrainerRepository trainerRepository;

    @InjectMocks
    TrainerServiceImpl trainerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllTrainers_shouldCallTheRepository() {
        trainerService.getAllTrainers();

        verify(trainerRepository).findAll();
    }

    @Test
    void getTrainer_shouldCallTheRepository() {
        trainerService.getTrainer("Ash");

        verify(trainerRepository).findById("Ash");
    }

    @Test
    void createTrainer_shouldCallTheRepository() {
        var ash = new Trainer();
        trainerService.createTrainer(ash);

        verify(trainerRepository).save(ash);
    }

    @Test
    void updateTrainer_shouldCallTheRepository(){
        var ash = new Trainer();
        trainerService.updateTrainer(ash);

        verify(trainerRepository).save(ash);
    }

    @Test
    void deleteTrainer_shouldCallTheRepository(){
        trainerService.deleteTrainer("John");

        verify(trainerRepository).deleteById("John");
    }

    @Test
    void deleteTrainer_shouldDoNothingForAshAndMistyTheRepository(){
        trainerService.deleteTrainer("Ash");
        trainerService.deleteTrainer("Misty");

        verifyZeroInteractions(trainerRepository);
    }
}