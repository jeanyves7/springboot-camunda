package com.bpm.workflow.Repositories;


import com.bpm.workflow.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectsRepository extends JpaRepository<Project,Long> {

    @Override
    <S extends Project> S save(S s);

    @Modifying
    @Query("update Project p set p.isValidated = ?2 where p.name = ?1")
    void updateProjectApprovalStatus(String firstname,boolean status);

    @Modifying
    @Query("update Project p set p.notified = true where p.email = ?1")
    void updateNotificationStatus(String email);

    @Modifying
    @Query("SELECT p from Project p where p.notified=false and p.isValidated=true ")
    List<Project> findAllProjectsToSend();

}
