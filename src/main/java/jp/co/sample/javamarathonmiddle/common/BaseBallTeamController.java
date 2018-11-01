package jp.co.sample.javamarathonmiddle.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.javamarathonmiddle.domain.BaseBallTeam;
import jp.co.sample.javamarathonmiddle.service.BaseBallTeamService;


/**
 * 野球チームの情報表示を行うコントローラ.
 * 
 * @author igamasayuki
 */
@Controller
@RequestMapping(value = "/5km")
public class BaseBallTeamController {
	@Autowired BaseBallTeamService service;
	
	/**
	 * 野球チームのリストを表示する.
	 * 
	 * @param model モデル
	 * @return 野球チームのリスト表示画面
	 */
	@RequestMapping(value = "/teamlist")
	public String teamList(Model model) {
		List<BaseBallTeam> teamList = service.findAll();
		model.addAttribute("teamList", teamList);
		return "teamlist";
	}
	
	/**
	 * 野球チームの詳細情報を表示する.
	 * 
	 * @param id チームのid
	 * @param model モデル
	 * @return 野球チームの詳細情報表示画面
	 */
	@RequestMapping(value = "/detailteam")
	public String datailTeam(Integer id,Model model) {
		BaseBallTeam team = service.search(id);
		model.addAttribute("team", team);
		return "detailteam";
	}
}
