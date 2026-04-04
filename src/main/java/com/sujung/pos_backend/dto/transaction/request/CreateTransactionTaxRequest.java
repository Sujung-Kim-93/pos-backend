package com.sujung.pos_backend.dto.transaction.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTransactionTaxRequest {

    @NotBlank
    @Size(max = 20)
    private String taxScopeCode;

    @Positive
    private Integer itemLineNumber;

    @NotNull
    @Positive
    private Integer taxSequence;

    @NotBlank
    @Size(max = 20)
    private String taxTypeCode;

    @Size(max = 50)
    private String taxDescription;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal taxableAmount;

    @NotNull
    @DecimalMin("0.0000")
    private BigDecimal taxRate;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal taxAmount;
}