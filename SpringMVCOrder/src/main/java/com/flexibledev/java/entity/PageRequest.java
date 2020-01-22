package com.flexibledev.java.entity;

public class PageRequest implements Pageable {

	private int index;
	private int size;

	public PageRequest(int index, int size) {
		this.index = index;
		this.size = size;
	}

	@Override
	public int getIndex() {
		return index;
	}

	@Override
	public int getSize() {
		return size;
	}

}
