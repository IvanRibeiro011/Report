package com.recife.ifpe.industry.report.repository;

import com.recife.ifpe.industry.report.entity.Setor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SetorRepository {

    private final JdbcTemplate jdbcTemplate;

    public SetorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Setor setor) {
        String sql = "INSERT INTO setores (nome) VALUES (?)";
        jdbcTemplate.update(sql, setor.getNome());
    }

    public Setor findById(Long id){
        String sql = "SELECT * FROM setores WHERE setor_id = ?";
        return jdbcTemplate.queryForObject(sql,this::mapRowToSetor,id);
    }
    public List<Setor> findAll() {
        String sql = "SELECT * FROM setores";
        return jdbcTemplate.query(sql, this::mapRowToSetor);
    }

    private Setor mapRowToSetor(ResultSet rs, int rowNum) throws SQLException {
        Setor setor = new Setor();
        setor.setId(rs.getLong("id"));
        setor.setNome(rs.getString("nome"));
        return setor;
    }

    public void update(Setor setor) {
        String sql = "UPDATE setor SET nome = ? WHERE id = ?";
        jdbcTemplate.update(sql, setor.getNome(), setor.getId());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM setor WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}