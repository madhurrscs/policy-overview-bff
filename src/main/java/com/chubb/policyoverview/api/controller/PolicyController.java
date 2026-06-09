package com.chubb.policyoverview.api.controller;

import com.chubb.policyoverview.api.dto.response.PolicyResponse;
import com.chubb.policyoverview.api.mapper.DomainToResponseDto;
import com.chubb.policyoverview.domain.models.Policy;
import com.chubb.policyoverview.service.PolicyService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PolicyController {

    private static final String HEALTH_OK = "OK";

    private final PolicyService policyService;
    private final DomainToResponseDto responseMapper;

    public PolicyController(PolicyService policyService, DomainToResponseDto responseMapper) {
        this.policyService = policyService;
        this.responseMapper = responseMapper;
    }

    @GetMapping("/health")
    public String health() {
        return HEALTH_OK;
    }

    @GetMapping("/api/v1/policies")
    public List<PolicyResponse> policies() {
        List<Policy> policies = policyService.getPolicies();
        return responseMapper.toResponseList(policies);
    }
}
