-- Create Table: Role
CREATE TABLE roles (
    role_id SERIAL PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL
);

-- Create Table: Permission
CREATE TYPE permission_type AS ENUM ('READ', 'READ_WRITE');

CREATE TABLE permissions (
    permission_id SERIAL PRIMARY KEY,
    permission_type permission_type NOT NULL
);

-- Create Table: Role_Permission (many-to-many)
CREATE TABLE role_permissions (
    role_id INT REFERENCES roles(role_id) ON DELETE CASCADE,
    permission_id INT REFERENCES permissions(permission_id) ON DELETE CASCADE,
    PRIMARY KEY (role_id, permission_id)
);

-- Create Table: Users
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role_id INT REFERENCES roles(role_id)
);
