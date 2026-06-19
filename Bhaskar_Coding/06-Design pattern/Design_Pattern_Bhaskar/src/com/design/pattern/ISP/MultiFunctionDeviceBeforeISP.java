package com.design.pattern.ISP;

public interface MultiFunctionDeviceBeforeISP {

	public void print();
	public void scan();
	public void fax();
}


class BasicPrinter implements MultiFunctionDeviceBeforeISP{

	@Override
	public void print() {
		System.out.println("Print");
		
	}

	@Override
	public void scan() {
		//not implemented
		
	}

	@Override
	public void fax() {
		// Not implemented
		
	}
	
}
