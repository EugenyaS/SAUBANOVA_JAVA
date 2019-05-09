package ru.saubanova.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.saubanova.app.models.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
