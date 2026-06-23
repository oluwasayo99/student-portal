-- ============================================
-- Users Table
-- ============================================
CREATE TABLE users (
    id              BIGINT IDENTITY(1,1) PRIMARY KEY,
    email           NVARCHAR(255) NOT NULL UNIQUE,
    password_hash   NVARCHAR(255) NOT NULL,
    first_name      NVARCHAR(100) NOT NULL,
    last_name       NVARCHAR(100) NOT NULL,
    role            NVARCHAR(20)  NOT NULL,
    is_active       BIT           DEFAULT 1,
    created_at      DATETIME2     DEFAULT CURRENT_TIMESTAMP,
    updated_at      DATETIME2     DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_role CHECK (role IN ('ADMIN', 'STAFF', 'STUDENT'))
);

CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_users_role ON users(role);
CREATE INDEX idx_users_active ON users(is_active);
