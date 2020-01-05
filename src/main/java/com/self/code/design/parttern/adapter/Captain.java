package com.self.code.design.parttern.adapter;

import com.sun.rowset.internal.Row;

/**
 * @program: self-code
 * @description:
 * @author: GaoBo
 * @create: 2020/1/3
 **/
public class Captain {

	private RowingBoat rowingBoat;

	public Captain(){

	}

	public Captain(final RowingBoat rowingBoat){
		this.rowingBoat = rowingBoat;
	}

	void setRowingBoat(final RowingBoat rowingBoat){
		this.rowingBoat = rowingBoat;
	}

	void row(){
		rowingBoat.row();
	}

}
