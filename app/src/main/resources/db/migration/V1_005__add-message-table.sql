-- Таблица сообщений
CREATE TABLE IF NOT EXISTS messages (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    sender_id UUID NOT NULL REFERENCES users(id),
    receiver_id UUID NOT NULL REFERENCES users(id),
    content TEXT NOT NULL,
    sent_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);