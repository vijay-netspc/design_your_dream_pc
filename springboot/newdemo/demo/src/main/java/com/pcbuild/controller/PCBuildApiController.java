package com.pcbuild.controller;

import com.pcbuild.model.PCBuild;
import com.pcbuild.service.PCBuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pcbuilds")
public class PCBuildApiController {

    @Autowired
    private PCBuildService service;

    // Create a new build (POST)
    @PostMapping
    public PCBuild addBuild(@RequestBody PCBuild build) {
        return service.addBuild(build);
    }

    // Get all builds (GET)
    @GetMapping
    public List<PCBuild> getAllBuilds() {
        return service.getAllBuilds();
    }

    // Get a build by ID (GET)

    // Update a build (PUT)
    @PutMapping("/{id}")
    public PCBuild updateBuild(@PathVariable Long id, @RequestBody PCBuild updatedBuild) {
        return service.updateBuild(id, updatedBuild);
    }

    // Delete a build (DELETE)
    @DeleteMapping("/{id}")
    public String deleteBuild(@PathVariable Long id) {
        return service.deleteBuild(id) ? "Build deleted successfully" : "Build ID not found";
    }
}
