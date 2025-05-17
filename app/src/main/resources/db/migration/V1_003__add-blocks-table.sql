CREATE TABLE IF NOT EXISTS blocks (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    blocker_id UUID NOT NULL REFERENCES users(id),
    blocked_user_id UUID NOT NULL REFERENCES users(id),
    block_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT unique_block UNIQUE (blocker_id, blocked_user_id)
);