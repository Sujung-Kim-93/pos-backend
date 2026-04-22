package com.sujung.pos_backend.dto.transaction.request;

import jakarta.validation.Valid;
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
import java.util.List;

import com.sujung.pos_backend.dto.transaction.request.CreateTransactionItemAdjustmentRequest;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTransactionItemRequest {

    @NotNull
    @Positive
    private Integer lineNumber;

    @NotBlank
    @Size(max = 30)
    private String sku;

    @NotBlank
    @Size(max = 100)
    private String itemDescription;

    @NotNull
    @Positive
    private Integer quantity;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal unitPrice;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal originalSalesAmount;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal discountAmount;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal totalSalesAmount;

    @Valid
    private List<CreateTransactionItemAdjustmentRequest> adjustments;
}