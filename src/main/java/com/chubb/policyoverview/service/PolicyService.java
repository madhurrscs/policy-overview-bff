package com.chubb.policyoverview.service;

import com.chubb.policyoverview.domain.models.LineOfBusiness;
import com.chubb.policyoverview.domain.models.Policy;
import com.chubb.policyoverview.domain.models.Region;
import com.chubb.policyoverview.domain.models.Status;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class PolicyService {

    public List<Policy> getPolicies() {
        return List.of(
                new Policy(
                        UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6"),
                        "POL-1001", "Acme Pte Ltd",
                        LineOfBusiness.PROPERTY, Status.ACTIVE,
                        new BigDecimal("12500.00"), "SGD",
                        LocalDate.of(2025, 1, 1), LocalDate.of(2025, 12, 31),
                        Region.SINGAPORE, "Jane Lim", false,
                        Instant.parse("2025-01-01T08:30:00Z"), Instant.parse("2025-06-01T10:15:00Z")),
                new Policy(
                        UUID.fromString("9c858901-8a57-4791-81fe-4c455b099bc9"),
                        "POL-1002", "Sato Holdings",
                        LineOfBusiness.MARINE, Status.PENDING,
                        new BigDecimal("8900.50"), "JPY",
                        LocalDate.of(2025, 3, 15), LocalDate.of(2026, 3, 14),
                        Region.JAPAN, "Hiroshi Sato", true,
                        Instant.parse("2025-03-15T09:00:00Z"), Instant.parse("2025-05-20T14:45:00Z")),
                new Policy(
                        UUID.fromString("b2c3d4e5-f6a7-4890-9123-456789abcdef"),
                        "POL-1003", "Nair Enterprises",
                        LineOfBusiness.ACCIDENT_AND_HEALTH, Status.EXPIRED,
                        new BigDecimal("4300.00"), "AUD",
                        LocalDate.of(2024, 6, 1), LocalDate.of(2025, 5, 31),
                        Region.AUSTRALIA, "Priya Nair", false,
                        Instant.parse("2024-06-01T07:30:00Z"), Instant.parse("2025-06-01T08:00:00Z")));
    }
}
