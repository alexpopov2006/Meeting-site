-- Таблица пользователей
CREATE TABLE IF NOT EXISTS users (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    firstName VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    passwordHash VARCHAR(256) NOT NULL,
    isActive BOOLEAN NOT NULL,
    likesReceived INT NOT NULL,
    matches INT NOT NULL
);

