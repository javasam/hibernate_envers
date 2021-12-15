package com.example.demo;

import org.springframework.data.jpa.repository.*;

public interface EntityRepository extends JpaRepository<Entity, Long> {
}
