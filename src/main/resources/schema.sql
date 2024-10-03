CREATE TABLE IF NOT EXISTS setor
(
    id
    BIGINT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    nome
    VARCHAR
(
    255
) NOT NULL
    );

CREATE TABLE IF NOT EXISTS funcionario
(
    id
    BIGINT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    nome
    VARCHAR
(
    255
) NOT NULL,
    tipo_funcionario VARCHAR
(
    50
),
    setor_id BIGINT,
    FOREIGN KEY
(
    setor_id
) REFERENCES setor
(
    id
)
    );

CREATE TABLE IF NOT EXISTS problema
(
    id
    BIGINT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    data_ocorrido
    TIMESTAMP
    NOT
    NULL,
    tipo_problema
    VARCHAR
(
    255
),
    funcionario_id BIGINT,
    setor_id BIGINT,
    FOREIGN KEY
(
    funcionario_id
) REFERENCES funcionario
(
    id
),
    FOREIGN KEY
(
    setor_id
) REFERENCES setor
(
    id
)
    );