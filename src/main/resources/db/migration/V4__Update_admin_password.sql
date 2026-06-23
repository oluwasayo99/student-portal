-- Update default admin password to exactly 'admin123'
UPDATE users
SET password_hash = '$2a$10$FHbMI3W6b0HqIv0SO6EcvOCGv8cifa49ppnkZK7UjOZulDwQj/pia'
WHERE email = 'admin@studentportal.com';
