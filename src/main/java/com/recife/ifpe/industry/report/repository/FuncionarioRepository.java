package com.recife.ifpe.industry.report.repository;

import com.recife.ifpe.industry.report.entity.Funcionario;
import com.recife.ifpe.industry.report.enumeration.TipoFuncionario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FuncionarioRepository {

    private final JdbcTemplate jdbcTemplate;

    public FuncionarioRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Funcionario funcionario) {
        String sql = "INSERT INTO funcionarios (nome, tipo_funcionario, setor_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                funcionario.getNome(),
                funcionario.getTipoFuncionario().name(),
                funcionario.getSetor().getId()
        );
    }

    public Funcionario findById(Long id) {
        String sql = "SELECT * FROM funcionarios WHERE funcionario_id = ?";
        return jdbcTemplate.queryForObject(sql, this::mapRowToFuncionario, id);
    }

    public List<Funcionario> findAll() {
        String sql = "SELECT * FROM funcionarios";
        return jdbcTemplate.query(sql, this::mapRowToFuncionario);
    }

    public List<Funcionario> findBySetorId(Long setorId) {
        String sql = "SELECT * FROM funcionarios WHERE setor_id = ?";
        return jdbcTemplate.query(sql, this::mapRowToFuncionario, setorId);
    }

    private Funcionario mapRowToFuncionario(ResultSet rs, int rowNum) throws SQLException {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(rs.getLong("id"));
        funcionario.setNome(rs.getString("nome"));
        funcionario.setTipoFuncionario(TipoFuncionario.valueOf(rs.getString("tipo_funcionario")));
        return funcionario;
    }

    public void update(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET nome = ?, tipo_funcionario_id = ?, setor_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, funcionario.getNome(), funcionario.getTipoFuncionario().getDescricao(),
                funcionario.getSetor().getId(), funcionario.getId());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM funcionario WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}