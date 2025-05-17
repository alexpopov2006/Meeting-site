-- Таблица профилей
CREATE TABLE IF NOT EXISTS profiles (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID NOT NULL REFERENCES users(id),
    gender VARCHAR(10) CHECK (gender IN ('MALE', 'FEMALE')),
    birth_date DATE,
    about_me VARCHAR(500),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);