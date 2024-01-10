set foreign_key_checks = 0;

delete from category;

set foreign_key_checks = 1;


INSERT INTO category (id, name, description) VALUES
(1, 'Electronics', 'Modern electronic devices'),
(2, 'Clothing', 'Current and stylish fashion'),
(3, 'Books', 'Diverse selection of books for reading');

