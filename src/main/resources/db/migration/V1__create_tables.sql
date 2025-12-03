CREATE TABLE genres (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE cinemas (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL
);

CREATE TABLE movies (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    age_rating VARCHAR(10),
    duration_minutes INT,
    release_year INT,
    cinema_id BIGINT NOT NULL REFERENCES cinemas (id)
);

CREATE TABLE movie_genres (
    movie_id BIGINT NOT NULL REFERENCES movies (id) ON DELETE CASCADE,
    genre_id BIGINT NOT NULL REFERENCES genres (id) ON DELETE CASCADE,
    PRIMARY KEY (movie_id, genre_id)
);


    )
