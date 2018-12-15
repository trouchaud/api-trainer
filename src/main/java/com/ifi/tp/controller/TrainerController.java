package com.ifi.tp.controller;

import com.ifi.tp.bo.Trainer;
import com.ifi.tp.service.ProductService;
import com.ifi.tp.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

    @Autowired
    private final TrainerService trainerService;

    TrainerController(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    @GetMapping("")
    Iterable<Trainer> getAllTrainers(){
        return this.trainerService.getAllTrainers();
    }

    @GetMapping("/{name}")
    Trainer getTrainer(@PathVariable String name){
        return this.trainerService.getTrainer(name);
    }

    @PostMapping("")
    Trainer createTrainer(@RequestBody Trainer trainer){
        return this.trainerService.createTrainer(trainer);
    }

    @PutMapping("")
    Trainer updateTrainer(@RequestBody Trainer trainer) {
        return this.trainerService.updateTrainer(trainer);
    }

    @DeleteMapping("/{name}")
    void deleteTrainer(@PathVariable String name) {
        this.trainerService.deleteTrainer(name);
    }
}
