-- 1. transaction_type_classification
CREATE TABLE transaction_type_classification (
    transaction_type_code VARCHAR(20) PRIMARY KEY,
    transaction_type_name VARCHAR(30) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    display_sequence INT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 2. transaction_status_classification
CREATE TABLE transaction_status_classification (
    transaction_status_code VARCHAR(20) PRIMARY KEY,
    transaction_status_name VARCHAR(30) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    display_sequence INT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 3. payment_type_classification
CREATE TABLE payment_type_classification (
    payment_type_code VARCHAR(30) PRIMARY KEY,
    payment_type_name VARCHAR(30) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    display_sequence INT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 4. payment_status_classification
CREATE TABLE payment_status_classification (
    payment_status_code VARCHAR(20) PRIMARY KEY,
    payment_status_name VARCHAR(30) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    display_sequence INT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 5. transactions
CREATE TABLE transactions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    transaction_number VARCHAR(30) NOT NULL,
    transaction_type_code VARCHAR(20) NOT NULL,
    transaction_status_code VARCHAR(20) NOT NULL,

    transaction_timestamp DATETIME NOT NULL,
    business_date DATE NOT NULL,

    store_id VARCHAR(10) NOT NULL,
    register_id VARCHAR(10) NOT NULL,
    receipt_number VARCHAR(10) NOT NULL,
    cashier_id VARCHAR(20) NOT NULL,

    customer_id VARCHAR(50),

    subtotal_amount DECIMAL(15,2) NOT NULL,
    discount_amount DECIMAL(15,2) NOT NULL,
    tax_amount DECIMAL(15,2) NOT NULL,
    total_amount DECIMAL(15,2) NOT NULL,
    paid_amount DECIMAL(15,2) NOT NULL,
    change_amount DECIMAL(15,2) NOT NULL,

    original_transaction_id BIGINT,

    notes VARCHAR(500),

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    UNIQUE (transaction_number),
    UNIQUE (business_date, store_id, register_id, receipt_number),

    FOREIGN KEY (transaction_type_code)
        REFERENCES transaction_type_classification(transaction_type_code),

    FOREIGN KEY (transaction_status_code)
        REFERENCES transaction_status_classification(transaction_status_code),

    FOREIGN KEY (original_transaction_id)
        REFERENCES transactions(id)
);