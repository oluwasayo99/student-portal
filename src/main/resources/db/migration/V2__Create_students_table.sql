-- ============================================
-- Students Table
-- ============================================
CREATE TABLE students (
    id                BIGSERIAL PRIMARY KEY,
    user_id           BIGINT NOT NULL UNIQUE,
    student_number    VARCHAR(50) NOT NULL UNIQUE,
    date_of_birth     DATE,
    phone             VARCHAR(20),
    address           VARCHAR(500),
    department_code   VARCHAR(10) NOT NULL,
    degree_type       VARCHAR(5)  NOT NULL, -- 'U' or 'P'
    enrollment_year   INT          NOT NULL,
    enrollment_date   DATE DEFAULT CURRENT_TIMESTAMP,
    created_at        TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at        TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_student_user
        FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE INDEX idx_students_number ON students(student_number);
CREATE INDEX idx_students_user_id ON students(user_id);
CREATE INDEX idx_students_dept_year ON students(department_code, enrollment_year);
