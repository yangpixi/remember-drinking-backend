ALTER TABLE t_record
ADD COLUMN record_id VARCHAR(32) NOT NULL;

CREATE INDEX idx_record_record_id ON t_record(record_id);

COMMENT ON COLUMN t_record.record_id IS '客户端的喝水记录uuid，方便客户端删除某个记录后与数据库保持同步';