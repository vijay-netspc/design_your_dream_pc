package com.pcbuild.service;

import com.pcbuild.model.PCBuild;
import com.pcbuild.repository.PCBuildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PCBuildService {
    @Autowired
    private PCBuildRepository repository;

    public PCBuild addBuild(PCBuild build) {
        return repository.save(build);
    }

    public List<PCBuild> getAllBuilds() {
        return repository.findAll();
    }

    public PCBuild updateBuild(Long id, PCBuild updatedBuild) {
        return repository.findById(id).map(build -> {
            build.setName(updatedBuild.getName());
            build.setProcessor(updatedBuild.getProcessor());
            build.setGraphicsCard(updatedBuild.getGraphicsCard());
            build.setMemory(updatedBuild.getMemory());
            build.setStorage(updatedBuild.getStorage());
            build.setPowerSupply(updatedBuild.getPowerSupply());
            return repository.save(build);
        }).orElse(null);
    }

    public boolean deleteBuild(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
