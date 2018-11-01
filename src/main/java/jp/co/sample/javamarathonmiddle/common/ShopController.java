package jp.co.sample.javamarathonmiddle.common;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.javamarathonmiddle.domain.Shop;
import jp.co.sample.javamarathonmiddle.form.ShopForm;
import jp.co.sample.javamarathonmiddle.service.ShopService;

/**
 * 洋服ショップの表示を行うコントローラ.
 * 
 * @author igamasayuki
 */
@Controller
@Transactional
@RequestMapping(value = "/15km")
public class ShopController {
	@Autowired
	private ShopService service;

	/**
	 * フォームの初期化.
	 * 
	 * @return 初期化されたフォーム
	 */
	@ModelAttribute
	private ShopForm setUpForm() {
		return new ShopForm();
	}
	
	/**
	 * 洋服検索画面を表示する.
	 * 
	 * @param model モデル
	 * @return 洋服検索画面
	 */
	@RequestMapping(value = "/index")
	public String index(Model model) {
		Map<Integer, String> genderMap = new LinkedHashMap<>();
		genderMap.put(1, "Man");
		genderMap.put(0, "Woman");

		Map<String, String> colorMap = new LinkedHashMap<>();
		colorMap.put("赤", "赤");
		colorMap.put("青", "青");
		colorMap.put("黄色", "黄色");
		colorMap.put("白", "白");

		model.addAttribute("genderMap", genderMap);
		model.addAttribute("colorMap", colorMap);
		return "clothesshop";
	}

	/**
	 * 検索結果画面を表示する.
	 * 
	 * @param model
	 *            モデル
	 * @param form
	 *            フォーム
	 * @return 検索結果画面
	 */
	@RequestMapping(value = "/search")
	public String search(Model model, @Validated ShopForm form, BindingResult result) {
		if (result.hasErrors()) {
			return index(model);
		}
		List<Shop> shopList = service.findByGenderAndColor(form.getIntGender(), form.getColor());
		model.addAttribute("shopList", shopList);
		return index(model);
	}
}
