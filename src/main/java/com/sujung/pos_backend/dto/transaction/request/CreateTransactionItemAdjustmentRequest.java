package com.sujung.pos_backend.dto.transaction.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class CreateTransactionItemAdjustmentRequest {

    @NotBlank
    @Size(max = 30)
    private String adjustmentTypeCode;

    @Size(max = 30)
    private String adjustmentEventCode;

    @NotBlank
    @Size(max = 30)
    private String adjustmentReasonCode;

    @Size(max = 100)
    private String adjustmentDescription;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal adjustmentAmount;
}