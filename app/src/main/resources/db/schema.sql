-- Таблица пользователей
CREATE TABLE IF NOT EXISTS users (
    id UUID PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Таблица профилей
CREATE TABLE IF NOT EXISTS profiles (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL REFERENCES users(id),
    gender VARCHAR(10) CHECK (gender IN ('MALE', 'FEMALE')),
    birth_date DATE,
    about_me TEXT,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Таблица фотографий
CREATE TABLE IF NOT EXISTS photos (
    id UUID PRIMARY KEY,
    profile_id UUID NOT NULL REFERENCES profiles(id),
    url VARCHAR(255) NOT NULL,
    is_main BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Таблица блокировок
CREATE TABLE IF NOT EXISTS blocks (
    id UUID PRIMARY KEY,
    blocker_id UUID NOT NULL REFERENCES users(id),
    blocked_user_id UUID NOT NULL REFERENCES users(id),
    block_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT unique_block UNIQUE (blocker_id, blocked_user_id)
);

-- Таблица сообщений
CREATE TABLE IF NOT EXISTS messages (
    id UUID PRIMARY KEY,
    sender_id UUID NOT NULL REFERENCES users(id),
    receiver_id UUID NOT NULL REFERENCES users(id),
    content TEXT NOT NULL,
    sent_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Таблица лайков
CREATE TABLE IF NOT EXISTS likes (
    id UUID PRIMARY KEY,
    liker_id UUID NOT NULL REFERENCES users(id),
    liked_user_id UUID NOT NULL REFERENCES users(id),
    like_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT unique_like UNIQUE (liker_id, liked_user_id)
);