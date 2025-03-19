package org.example.taskmanagerserver.repository;

import org.example.taskmanagerserver.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagEntity, Long> {
}
