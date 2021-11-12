package com.bpm.workflow.Repositories;


import com.bpm.workflow.dto.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepository extends JpaRepository<Project,Long> {

    @Override
    <S extends Project> S save(S s);
}
