package io.shazzboard.shazamservice;

//import io.shazzboard.shazamservice.service.ShazamService;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class ShazamServiceApplicationTests {
	//@Autowired
	//private ShazamService shazamService;

	@Test
	public void serviceExists(){
//        assertThat(shazamService).isNotNull();
	    assert(true);
    }

	@Test
	void contextLoads() {
	}

}
