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
public class CreateTransactionPaymentRequest {

    @NotNull
    @Positive
    private Integer lineNumber;

    @NotBlank
    @Size(max = 30)
    private String paymentTypeCode;

    @NotBlank
    @Size(max = 20)
    private String paymentStatusCode;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal paymentAmount;

    @Size(max = 25)
    private String maskedCardNumber;

    @Size(max = 100)
    private String cardToken;

    @Size(max = 30)
    private String approvalCode;
}