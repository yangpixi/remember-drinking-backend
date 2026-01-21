ALTER TABLE t_record
ALTER COLUMN record_id TYPE VARCHAR(36);

ALTER TABLE t_record
ADD CONSTRAINT uk_record_id UNIQUE (record_id);