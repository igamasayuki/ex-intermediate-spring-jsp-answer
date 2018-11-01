package jp.co.sample.javamarathonmiddle.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.javamarathonmiddle.domain.Hotel;

/**
 * hotelsテーブルを操作するリポジトリ.
 * 
 * @author igamasayuki
 */
@Repository
public class HotelRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * ResultSetからHotelに変換するRowMapper.
	 */
	private static final RowMapper<Hotel> hotelRowMapper = (rs, i) ->{
		Hotel hotel = new Hotel();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking(rs.getString("parking"));
		return hotel;
	};
	
	/**
	 * 引数の値段以下のホテルを検索する.
	 * 
	 * @param price 値段
	 * @return List<Hotel> 検索されたホテルのリスト
	 */
	public List<Hotel> findByPriceOrLess(int price){
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking "
				+ "FROM hotels "
				+ "WHERE price<=:price "
				+ "ORDER BY price "
				+ ";";
		List<Hotel> hotelList = template.query(sql, param, hotelRowMapper);
		return hotelList;
	}
}
