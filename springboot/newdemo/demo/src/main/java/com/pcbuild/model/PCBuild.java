package com.pcbuild.model;

import jakarta.persistence.*;

@Entity
@Table(name = "builds")
public class PCBuild {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String processor;
    
    @Column(nullable = false)
    private String graphicsCard;
    
    @Column(nullable = false)
    private String memory;
    
    @Column(nullable = false)
    private String storage;
    
    @Column(nullable = false)
    private String powerSupply;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getProcessor() { return processor; }
    public void setProcessor(String processor) { this.processor = processor; }

    public String getGraphicsCard() { return graphicsCard; }
    public void setGraphicsCard(String graphicsCard) { this.graphicsCard = graphicsCard; }

    public String getMemory() { return memory; }
    public void setMemory(String memory) { this.memory = memory; }

    public String getStorage() { return storage; }
    public void setStorage(String storage) { this.storage = storage; }

    public String getPowerSupply() { return powerSupply; }
    public void setPowerSupply(String powerSupply) { this.powerSupply = powerSupply; }
}
