package com.bpm.workflow.dto;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "project")
public class Project  {

    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="isvalidated")
    private boolean isValidated=false;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Project() {
        this.name = "";
        this.description = "";

    }

    public  void setName(String name){
        this.name=name;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
