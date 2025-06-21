CREATE TABLE IF NOT EXISTS users (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    firstName VARCHAR(50) NOT NULL,
    surName VARCHAR(50) NOT NULL,
    dadName VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    passwordHash VARCHAR(256) NOT NULL,
    address_id UUID,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    isActive BOOLEAN NOT NULL,
    likesReceived INT NOT NULL,
    matches INT NOT NULL,
    CONSTRAINT fk_address FOREIGN KEY (address_id) REFERENCES address(id) ON DELETE SET NULL
);

