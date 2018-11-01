package jp.co.sample.javamarathonmiddle.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.javamarathonmiddle.domain.Hotel;
import jp.co.sample.javamarathonmiddle.form.HotelForm;
import jp.co.sample.javamarathonmiddle.service.HotelService;

/**
 * ホテル検索を表示するコントローラ.
 * 
 * @author igamasayuki
 */
@Controller
@Transactional
@RequestMapping(value = "/10km")
public class HotelController {
	/**
	 * フォームの初期化.
	 * 
	 * @return  初期化されたフォーム
	 */
	@ModelAttribute
	private HotelForm setUpForm() {
		return new HotelForm();
	}
	
	@Autowired
	HotelService service;
	
	/**
	 * ホテル検索画面を表示する.
	 * 
	 * @return ホテル検索画面
	 */
	@RequestMapping(value = "/hotelsearch")
	public String hotelSearch(Model model) {
		return "hotelsearch";
	}
	
	/**
	 * ホテル検索結果画面を表示する.
	 * 
	 * @param model モデル
	 * @param form　フォーム
	 * @return　ホテル検索結果画面
	 */
	@RequestMapping(value = "/search")
	public String Search(Model model,
			@Validated HotelForm form,
			BindingResult result) {
		
		if(result.hasErrors()) {
			return hotelSearch(model);
		}
		
		List<Hotel> hotelList = service.findByPriceOrLess(form.getIntPrice());
		model.addAttribute("hotelList", hotelList);
		return "hotelsearch";
	}
}
