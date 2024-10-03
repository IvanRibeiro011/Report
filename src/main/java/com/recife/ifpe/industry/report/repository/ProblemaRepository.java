package com.recife.ifpe.industry.report.repository;

import com.recife.ifpe.industry.report.entity.Funcionario;
import com.recife.ifpe.industry.report.entity.Problema;
import com.recife.ifpe.industry.report.entity.Setor;
import com.recife.ifpe.industry.report.enumeration.TipoProblema;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProblemaRepository {

    private final JdbcTemplate jdbcTemplate;
    private final FuncionarioRepository funcionarioRepository;
    private final SetorRepository setorRepository;

    public ProblemaRepository(JdbcTemplate jdbcTemplate, FuncionarioRepository funcionarioRepository, SetorRepository setorRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.funcionarioRepository = funcionarioRepository;
        this.setorRepository = setorRepository;
    }

    public void save(Problema problema) {
        String sql = "INSERT INTO problemas (data_ocorrido, tipo_problema, funcionario_id, setor_id) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                problema.getDataOcorrido(),
                problema.getTipoProblema().name(),
                problema.getFuncionario().getId(),
                problema.getSetor().getId()
        );
    }

    public List<Problema> findAll() {
        String sql = "SELECT * FROM problemas";
        return jdbcTemplate.query(sql, this::mapRowToProblema);
    }

    public Problema findById(Long id){
        String sql = "SELECT * FROM problemas WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,this::mapRowToProblema,id);
    }
    public List<Problema> findBySetorId(Long setorId) {
        String sql = "SELECT * FROM problemas WHERE setor_id = ?";
        return jdbcTemplate.query(sql, this::mapRowToProblema, setorId);
    }

    private Problema mapRowToProblema(ResultSet rs, int rowNum) throws SQLException {
        Problema problema = new Problema();
        problema.setId(rs.getLong("id"));
        problema.setDataOcorrido(rs.getTimestamp("data_ocorrido").toLocalDateTime());
        problema.setTipoProblema(TipoProblema.valueOf(rs.getString("tipo_problema")));

        Long funcionarioId = rs.getLong("funcionario_id");
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId);
        problema.setFuncionario(funcionario);

        Long setorId = rs.getLong("setor_id");
        Setor setor = setorRepository.findById(setorId);
        problema.setSetor(setor);

        return problema;
    }

    public void update(Problema problema) {
        String sql = "UPDATE problema SET data_ocorrido = ?, tipo_problema_id = ?, funcionario_id = ?, setor_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, problema.getDataOcorrido(), problema.getTipoProblema().getDescricao(),
                problema.getFuncionario().getId(), problema.getSetor().getId(), problema.getId());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM problema WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}