package jp.co.sample.javamarathonmiddle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sample.javamarathonmiddle.domain.Shop;
import jp.co.sample.javamarathonmiddle.repository.ShopRepository;

/**
 * 商品に関係するサービス.
 * 
 * @author igamasayuki
 */
@Service
public class ShopService {
	@Autowired
	private ShopRepository repository;

	/**
	 * 性別と色を指定して商品を検索する.
	 * 
	 * @param gender
	 *            性別
	 * @param color
	 *            色
	 * @return 検索された商品
	 */
	public List<Shop> findByGenderAndColor(int gender, String color) {
		List<Shop> shopList = repository.findByGenderAndColor(gender, color);
		return shopList;
	}
}
