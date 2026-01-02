-- 修改表
ALTER TABLE t_user
ALTER COLUMN phone TYPE VARCHAR(30)
USING phone::varchar;