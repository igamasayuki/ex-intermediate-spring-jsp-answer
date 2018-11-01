package jp.co.sample.javamarathonmiddle.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.javamarathonmiddle.domain.BaseBallTeam;

/**
 * baseball_teamsテーブルを操作するrepository.
 * 
 * @author igamasayuki
 */
@Repository
public class BaseBallTeamRepository {
	/**
	 * ResultSetからBaseBallTeamに変換するRowMapper.
	 */
	private static final RowMapper<BaseBallTeam> teamRowMapper = (rs, i) -> {
		BaseBallTeam team = new BaseBallTeam();
		team.setId(rs.getInt("id"));
		team.setInauguration(rs.getString("league_name"));
		team.setTeamName(rs.getString("team_name"));
		team.setHeadquarters(rs.getString("headquarters"));
		team.setInauguration(rs.getString("inauguration"));
		team.setHistory(rs.getString("history"));
		return team;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * id検索.
	 * 
	 * @param id id
	 * @return 検索された野球チーム情報
	 */
	public BaseBallTeam load(int id) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history "
				+ "FROM baseball_teams "
				+ "WHERE id=:id; ";
		BaseBallTeam team = template.queryForObject(sql, param, teamRowMapper);
		return team;
	}
	
	/**
	 * 全件検索.
	 * 
	 * @return List<BaseBallTeam> すべての野球チーム情報のリスト.
	 */
	public List<BaseBallTeam> findAll() {
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history "
				+ "FROM baseball_teams "
				+ "ORDER BY inauguration; ";
		List<BaseBallTeam> teamList = template.query(sql, teamRowMapper);
		return teamList;
	}
}
