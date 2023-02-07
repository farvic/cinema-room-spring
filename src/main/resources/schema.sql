CREATE TABLE CinemaRoom (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    total_rows INT,
    total_columns INT
);

CREATE TABLE Seat (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    row INT,
    column INT,
    cinema_room_id BIGINT,
    FOREIGN KEY (cinema_room_id) REFERENCES CinemaRoom(id)
);