CREATE TABLE t_record (
    id BIGINT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    amount_ml INTEGER NOT NULL,
    record_time INTEGER NOT NULL,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_record_user_id FOREIGN KEY (user_id) REFERENCES t_user(id) ON DELETE CASCADE
);

CREATE TRIGGER update_record_updated_at
    BEFORE UPDATE ON t_record
    FOR EACH ROW
    EXECUTE PROCEDURE update_updated_at_column();

CREATE INDEX idx_record_id ON t_record(id);
CREATE INDEX idx_record_user_id ON t_record(user_id);

COMMENT ON TABLE t_record IS '记录表';