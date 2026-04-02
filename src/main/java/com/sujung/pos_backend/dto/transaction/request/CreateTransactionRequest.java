package com.sujung.pos_backend.dto.transaction.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTransactionRequest {

    @NotBlank
    @Size(max = 30)
    private String transactionNumber;

    @NotNull
    private LocalDate businessDate;

    @NotNull
    private LocalDateTime transactionTimestamp;

    @NotBlank
    @Size(max = 10)
    private String storeId;

    @NotBlank
    @Size(max = 10)
    private String registerId;

    @NotBlank
    @Size(max = 10)
    private String receiptNumber;

    @NotBlank
    @Size(max = 20)
    private String cashierId;

    @NotBlank
    @Size(max = 20)
    private String transactionTypeCode;

    private Long originalTransactionId;

    @Size(max = 50)
    private String customerId;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal subtotalAmount;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal discountAmount;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal taxAmount;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal totalAmount;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal paidAmount;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal changeAmount;

    @Size(max = 500)
    private String notes;
    /*
     * @NotEmpty
     * 
     * @Valid
     * private List<CreateTransactionItemRequest> items;
     * 
     * @Valid
     * private List<CreateTransactionTaxRequest> taxes;
     * 
     * @NotEmpty
     * 
     * @Valid
     * private List<CreateTransactionPaymentRequest> payments;
     */
}