CREATE TABLE if NOT EXISTS t_user
(
    id
    INT
    auto_increment,
    username
    VARCHAR
(
    50
) NOT NULL,
    password VARCHAR
(
    100
) NOT NULL,
    NAME VARCHAR
(
    50
) NOT NULL,
    PRIMARY KEY
(
    id
)
    );

CREATE TABLE if NOT EXISTS t_authority
(
    id
    INT
    auto_increment,
    authority
    VARCHAR
(
    50
),
    PRIMARY KEY
(
    id
)
    );

CREATE TABLE if NOT EXISTS t_user_authorities
(
    id
    INT
    auto_increment,
    user_id
    INT,
    authority_id
    INT,
    PRIMARY
    KEY
(
    id
),
    FOREIGN KEY
(
    user_id
) REFERENCES t_user
(
    id
),
    FOREIGN KEY
(
    authority_id
) REFERENCES t_authority
(
    id
)
    );

CREATE TABLE if NOT EXISTS t_product
(
    id
    INT
    auto_increment,
    NAME
    VARCHAR
(
    100
) NOT NULL,
    price DECIMAL
(
    10,
    2
) NOT NULL DEFAULT 0,
    expire_date DATE,
    PRIMARY KEY
(
    id
)
    );
