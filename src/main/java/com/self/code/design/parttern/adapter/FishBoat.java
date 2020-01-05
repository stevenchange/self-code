package com.self.code.design.parttern.adapter;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @program: self-code
 * @description:
 * @author: GaoBo
 * @create: 2020/1/3
 **/
public class FishBoat {

	private static final Logger LOGGER = getLogger(FishBoat.class);

	void sail() {
		LOGGER.info("The fishing boat is sailing");
	}

}
