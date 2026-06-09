package com.chubb.policyoverview.infrastructure.persistence.repository;

import com.chubb.policyoverview.infrastructure.persistence.entity.PolicyEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository
        extends JpaRepository<PolicyEntity, UUID>, JpaSpecificationExecutor<PolicyEntity> {
}
