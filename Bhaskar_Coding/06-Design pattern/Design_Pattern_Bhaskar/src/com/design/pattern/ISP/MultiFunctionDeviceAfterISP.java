package com.design.pattern.ISP;

interface PrinterAfterISP {
	void print();
}

interface Scanner {
	void scan();
}

interface ColouredPrinter {
	void colorPrinter();
}

class BasicsPrinter implements PrinterAfterISP {

	@Override
	public void print() {
		System.out.println("Printer");

	}

}

public class MultiFunctionDeviceAfterISP implements PrinterAfterISP, Scanner, ColouredPrinter {

	@Override
	public void colorPrinter() {
		System.out.println("Color printer");

	}

	@Override
	public void scan() {
		System.out.println("scanner");

	}

	@Override
	public void print() {
		System.out.println("Printer");

	}

}
