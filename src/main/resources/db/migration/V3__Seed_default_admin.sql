-- Seed Default Admin
-- Password is 'admin123' (bcrypt hash)
INSERT INTO users (email, password_hash, first_name, last_name, role, is_active)
VALUES (
    'admin@studentportal.com',
    '$2a$10$wY.uV7k0j.gGvH7a7yI8yOc0LgqM6fM5yR4N/ySjFw6rR.1W1M3S2', -- This should be a real bcrypt hash of 'admin123'
    'System',
    'Admin',
    'ADMIN',
    1
);
