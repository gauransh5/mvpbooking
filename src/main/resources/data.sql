CREATE TABLE bookings (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          user_id BIGINT NOT NULL,
                          hotel_id BIGINT NOT NULL,
                          check_in_date DATE NOT NULL,
                          check_out_date DATE NOT NULL
);

INSERT INTO bookings (user_id, hotel_id, check_in_date, check_out_date)
VALUES
    (101, 201, '2024-05-20', '2024-05-25'),
    (102, 202, '2024-06-10', '2024-06-15'),
    (103, 203, '2024-07-05', '2024-07-10'),
    (104, 204, '2024-08-15', '2024-08-20');

-- Additional rows
INSERT INTO bookings (user_id, hotel_id, check_in_date, check_out_date)
VALUES
    (105, 205, '2024-09-01', '2024-09-05'),
    (106, 206, '2024-10-12', '2024-10-18'),
    (107, 207, '2024-11-20', '2024-11-25');
