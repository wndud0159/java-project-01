package kiosk.lotteria;

import kiosk.lotteria.controller.Kiosk;
import kiosk.lotteria.repository.ProductDaoImpl;

public class Main {
	public static void main(String[] args)throws Exception {
		Class.forName(ProductDaoImpl.DRIVER);
		final Kiosk kiosk = new Kiosk();
		kiosk.run();
	}
}
