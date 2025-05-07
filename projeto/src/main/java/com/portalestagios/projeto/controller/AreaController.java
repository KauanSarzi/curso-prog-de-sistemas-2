package com.portalestagios.projeto.controller;

import com.portalestagios.projeto.models.Area;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AreaController {
    private List<Area> areas;

    public AreaController() {
        areas = new ArrayList<>();
        areas.add(new Area(1L, "Tecnologia da Informação"));
        areas.add(new Area(2L, "Engenharia"));
        areas.add(new Area(3L, "Saúde"));
        areas.add(new Area(4L, "Administração"));
    }

    @GetMapping("/api/areas")
    public List<Area> getAreas() {
        return areas;
    }
}