package kr.co.bluezine;

import java.util.HashMap;
import java.util.Map;

import kr.co.bluezine.service.SugangService;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages={"kr.co.bluezine.mapper"})
public class Application implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
    public static void main(String[] args) {
    	
    	logger.debug("---------> Stating...");
        SpringApplication.run(Application.class, args);
        logger.debug("---------> Success!");
    }
    
    @Autowired
    @Qualifier("SugangServiceImpl")
    private SugangService sugangService;

	public void run(String... args) throws Exception {
		logger.debug("---------> Command Line start");
		Map<String, Object> map = new HashMap<String, Object>();
		//map.put("result", null);
		map.put("p_circ_cd", null);
		logger.debug("---------> Service before");
		//sugangService.deptList(map);
		String aa= sugangService.courseMyList(map);
		logger.debug(map.get("result").toString());
		
	}
}
