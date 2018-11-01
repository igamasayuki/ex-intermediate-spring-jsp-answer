package jp.co.sample.javamarathonmiddle.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.javamarathonmiddle.domain.Shop;

/**
 * shopsテーブルを操作するリポジトリー.
 * 
 * @author igamasayuki
 */
@Repository
public class ShopRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * ResultSetをShopに変換するRowMapper.
	 */
	private static final RowMapper<Shop> shopRowMapper = (rs, i) -> {
		Shop shop = new Shop();
		shop.setId(rs.getInt("id"));
		shop.setCategory(rs.getString("category"));
		shop.setGenre(rs.getString("genre"));
		shop.setGender(rs.getInt("gender"));
		shop.setColor(rs.getString("color"));
		shop.setPrice(rs.getInt("price"));
		shop.setSize(rs.getString("size"));
		return shop;
	};

	/**
	 * 性別と色を指定して商品を検索する.
	 * 
	 * @param gender
	 *            性別
	 * @param color
	 *            色
	 * @return 検索された商品のリスト
	 */
	public List<Shop> findByGenderAndColor(int gender, String color) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("gender", gender).addValue("color", color);
		String sql = "SELECT id, category, genre, gender, color, price, size " + "FROM shops "
				+ "WHERE gender=:gender AND color=:color " + "ORDER BY price;";
		List<Shop> shopList = template.query(sql, param, shopRowMapper);
		return shopList;
	}
}
