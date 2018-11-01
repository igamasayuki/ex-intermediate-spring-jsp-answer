package jp.co.rakus.javamarathonmiddle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.sample.javamarathonmiddle.service.ShopService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaMarathonMiddleApplicationTests {
	// @Autowired
	// private BaseBallTeamRepository baseBallTemaRepository;
	// @Autowired
	// private HotelRepository hotelRepository;
	// @Autowired
	// private ShopRepository shopRepository;
	@Autowired
	private ShopService shopService;

	@Test
	public void contextLoads() {
		System.out.println("a");
		shopService.findByGenderAndColor(0, "赤").forEach(System.out::println);
		// try {
		// List<Hotel> hotelList = hotelRepository.findByPriceOrLess(20000);
		// assertEquals(5, hotelList.size());
		// for (Hotel hotel : hotelList) {
		// System.out.println(hotel);
		// }
		// }catch (Throwable e) {
		// e.printStackTrace();
		// }
		// hotelRepository.findByPriceOrLess(20000).forEach(System.out::println);
		// baseBallTemaRepository.findAll().forEach(System.out::println);
		// System.out.println(baseBallTemaRepository.load(1));
	}

}
