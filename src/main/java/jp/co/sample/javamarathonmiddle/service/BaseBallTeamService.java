package jp.co.sample.javamarathonmiddle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sample.javamarathonmiddle.domain.BaseBallTeam;
import jp.co.sample.javamarathonmiddle.repository.BaseBallTeamRepository;

/**
 * 野球チームの情報を取得するサービス.
 * 
 * @author igamasayuki
 */
@Service
public class BaseBallTeamService {
	@Autowired
	private BaseBallTeamRepository repository;
	/**
	 * id検索.
	 * 
	 * @param id id
	 * @return 検索された野球チーム情報
	 */
	public BaseBallTeam search(int id) {
		return repository.load(id);
	}
	
	/**
	 * テーブルに登録されているすべての野球チームの情報を返す.
	 * 
	 * @return List<BaseBallTeam> すべての野球チームの情報のリスト
	 */
	public List<BaseBallTeam> findAll(){
		return repository.findAll();
	}
}
