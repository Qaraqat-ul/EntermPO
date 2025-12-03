INSERT INTO movies (id, title, description, age_rating, duration_minutes, release_year, cinema_id) VALUES
    (1, 'Movie A', 'Comedy movie', '12+', 100, 2020, 1),
    (2, 'Movie B', 'Action movie', '16+', 120, 2021, 1),
    (3, 'Movie C', 'Action Comedy', '16+', 110, 2019, 1);

INSERT INTO movie_genres (movie_id, genre_id) VALUES
    (1, 2), -- Movie A -> Comedy
    (2, 1), -- Movie B -> Action
    (3, 1), -- Movie C -> Action
    (3, 2); -- Movie C -> Comedy
