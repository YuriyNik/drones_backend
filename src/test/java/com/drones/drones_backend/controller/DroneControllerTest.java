package com.drones.drones_backend.controller;

import com.drones.drones_backend.model.Drone;
import com.drones.drones_backend.service.DroneService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.github.dockerjava.core.MediaType;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class DroneControllerTest {



    @Test
    void registerDrone() {
    }

    @Test
    void loadMedication() {
    }

    @Test
    void getLoadedMedications() {
    }

    @Test
    void getAvailableDrones() {
    }

    @Test
    void getBatteryLevel() {
    }
}