package org.springframework.boot.exam2.repository;

import org.springframework.boot.exam2.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectDao extends JpaRepository<Subject, Long> {
}
