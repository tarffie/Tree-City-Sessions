package dev.tarffie.TreeCitySessions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import dev.tarffie.TreeCitySessions.entities.Member;

@RepositoryRestResource
public interface MemberRepository extends JpaRepository<Member, Long> {
}
