-- enable property: spring.sql.init.mode=always
INSERT INTO users (id, full_name, password, email)
VALUES (5, 'admin', '$2a$10$eImiTXuWVxfZ7C8aP7g1Ge27H/N5p2wnWc3me8j8thE5MfISmQ9ZK', 'admin@example.com');
