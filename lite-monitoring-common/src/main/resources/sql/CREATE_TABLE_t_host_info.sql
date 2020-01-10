CREATE TABLE t_host_info (
    host_info_id BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    host VARCHAR(50),
    create_time BIGINT,
    used_memory BIGINT,
    total_memory BIGINT,
    used_cpu DOUBLE
)