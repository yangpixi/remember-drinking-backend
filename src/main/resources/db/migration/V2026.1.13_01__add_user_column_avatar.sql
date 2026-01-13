-- 添加用户头像字段

ALTER TABLE t_user
ADD COLUMN avatar TEXT DEFAULT NULL;

COMMENT ON COLUMN t_user.avatar IS '用户头像存储相对路径';