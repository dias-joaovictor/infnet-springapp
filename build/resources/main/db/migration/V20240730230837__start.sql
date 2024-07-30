CREATE TABLE Customer (
    id CHAR(36) NOT NULL PRIMARY KEY,
    fullName VARCHAR(255) NOT NULL,
    dateOfBirth DATE NOT NULL
);

CREATE TABLE Orders (
    id CHAR(36) NOT NULL PRIMARY KEY,
    orderDate DATE NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    fee DECIMAL(10, 2),
    totalAmount DECIMAL(10, 2) NOT NULL,
    customerId CHAR(36),
    FOREIGN KEY (customerId) REFERENCES Customer(id)
);

CREATE TABLE Payment (
    id CHAR(36) NOT NULL PRIMARY KEY,
    orderId CHAR(36) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    type VARCHAR(50) NOT NULL, -- 'Card' or 'Pix'
    FOREIGN KEY (orderId) REFERENCES Orders(id)
);

CREATE TABLE CardPayment (
    paymentId CHAR(36) NOT NULL PRIMARY KEY,
    cardHash VARCHAR(255) NOT NULL,
    cardholderName VARCHAR(255) NOT NULL,
    expiryDate DATE NOT NULL,
    FOREIGN KEY (paymentId) REFERENCES Payment(id)
);

CREATE TABLE PixPayment (
    paymentId CHAR(36) NOT NULL PRIMARY KEY,
    pixKey VARCHAR(255) NOT NULL,
    FOREIGN KEY (paymentId) REFERENCES Payment(id)
);

CREATE TABLE Fee (
    id CHAR(36) NOT NULL PRIMARY KEY,
    feeAmount DECIMAL(10, 2) NOT NULL,
    fromDate DATE NOT NULL
);
