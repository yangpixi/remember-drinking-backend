CREATE TABLE users (
    id BIGINT PRIMARY KEY,

    public_id UUID DEFAULT gen_random_uuid() NOT NULL UNIQUE,
    username VARCHAR(30) NOT NULL UNIQUE,
    password TEXT NOT NULL,
    phone BIGINT NOT NULL,

    enabled BOOLEAN DEFAULT TRUE NOT NULL,
    account_non_expired BOOLEAN DEFAULT TRUE NOT NULL,
    account_non_locked BOOLEAN DEFAULT TRUE NOT NULL,
    credentials_non_expired BOOLEAN DEFAULT TRUE NOT NULL,

    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO users(id, username, password, phone)
VALUES (1,'admin', 'test', 13327260090);

CREATE INDEX idx_users_username ON users(username);
CREATE INDEX idx_users_phone ON users(phone);

COMMENT ON TABLE users IS '用户表';
COMMENT ON COLUMN users.public_id IS '对外用户唯一标识';
COMMENT ON COLUMN users.password IS '存储加密过后的密码(如果使用oauth2登录，则登录后必须设置一个密码)';

CREATE TABLE roles (
    id BIGINT PRIMARY KEY,
    role_name VARCHAR(20) NOT NULL UNIQUE
);

INSERT INTO roles(id, role_name)
VALUES (1, 'admin'),
       (2, 'user'),
       (3, 'banned_user');

CREATE TABLE user_role (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_ur_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_ur_role FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE
);

CREATE INDEX idx_ur_role ON user_role(user_id);
CREATE INDEX idx_ur_user ON user_role(role_id);

COMMENT ON TABLE user_role IS '用户角色关联表';

INSERT INTO user_role(user_id, role_id)
VALUES (1, 1);

CREATE TABLE permissions(
    id BIGINT PRIMARY KEY,
    permission_name VARCHAR(20) NOT NULL
);

COMMENT ON TABLE permissions IS '权限表';

INSERT INTO permissions(id, permission_name)
VALUES (1, 'system:manage'),
       (2, 'record:add');

CREATE TABLE role_permission(
    role_id BIGINT NOT NULL,
    permission_id BIGINT NOT NULL,
    PRIMARY KEY (role_id, permission_id),
    CONSTRAINT fk_rp_role FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE,
    CONSTRAINT fk_rp_permission FOREIGN KEY (permission_id) REFERENCES permissions(id) ON DELETE CASCADE
);

CREATE INDEX idx_rp_role ON role_permission(role_id);
CREATE INDEX idx_rp_permission ON role_permission(permission_id);

COMMENT ON TABLE role_permission IS '角色权限表';

-- 管理员拥有所有权限
INSERT INTO role_permission(role_id, permission_id)
SELECT 1, id
FROM permissions;

-- 普通用户只有插入权限
INSERT INTO role_permission(role_id, permission_id)
SELECT 2, id
FROM permissions
WHERE permission_name IN ('record:add');

