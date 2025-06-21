-- Таблица лайков
CREATE TABLE IF NOT EXISTS likes (
    liker_id UUID NOT NULL REFERENCES users(id),
    liked_user_id UUID NOT NULL REFERENCES users(id),
    like_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT unique_like UNIQUE (liker_id, liked_user_id)
);