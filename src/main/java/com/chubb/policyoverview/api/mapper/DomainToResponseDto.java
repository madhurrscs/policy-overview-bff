package com.chubb.policyoverview.api.mapper;

import com.chubb.policyoverview.api.dto.response.PolicyResponse;
import com.chubb.policyoverview.domain.models.Policy;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DomainToResponseDto {

    public PolicyResponse toResponse(Policy policy) {
        return new PolicyResponse(
                policy.id(),
                policy.policyNumber(),
                policy.policyholderName(),
                policy.lineOfBusiness().getDisplayName(),
                policy.status().getDisplayName(),
                policy.premiumAmount(),
                policy.currency(),
                policy.effectiveDate(),
                policy.expiryDate(),
                policy.region().getDisplayName(),
                policy.underwriter(),
                policy.flaggedForReview(),
                policy.createdAt(),
                policy.updatedAt());
    }

    public List<PolicyResponse> toResponseList(List<Policy> policies) {
        return policies.stream().map(this::toResponse).toList();
    }
}
