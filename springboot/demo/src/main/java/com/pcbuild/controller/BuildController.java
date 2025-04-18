package com.pcbuild.controller;

import com.pcbuild.model.PCBuild;
import com.pcbuild.service.PCBuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/builds")
public class PCBuildController {
    @Autowired
    private PCBuildService service;

    @PostMapping
    public PCBuild addBuild(@RequestBody PCBuild build) {
        return service.addBuild(build);
    }

    @GetMapping
    public List<PCBuild> getAllBuilds() {
        return service.getAllBuilds();
    }

    @PutMapping("/{id}")
    public PCBuild updateBuild(@PathVariable Long id, @RequestBody PCBuild build) {
        return service.updateBuild(id, build);
    }

    @DeleteMapping("/{id}")
    public String deleteBuild(@PathVariable Long id) {
        return service.deleteBuild(id) ? "Build deleted successfully!" : "Build not found.";
    }
}
