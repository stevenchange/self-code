package com.self.code.design.parttern.adapter;

/**
 * @program: self-code
 * @description:
 * @author: GaoBo
 * @create: 2020/1/3
 **/
public class FishBoatAdapter implements RowingBoat {

	private FishBoat boat;

	public FishBoatAdapter() {
		boat = new FishBoat();
	}

	@Override
	public final void row() {
		boat.sail();
	}

}
