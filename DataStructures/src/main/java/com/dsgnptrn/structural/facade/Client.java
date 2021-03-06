package com.dsgnptrn.structural.facade;

public class Client {

	/*
	 * Facade Pattern is intended to provide a uniform interface to a set of interfaces in a subsystem. Facade defines a
	 * higher level interface that makes the subsystem easier to use. 1) Client will only know the Facade. 2) Facade is
	 * part of the system, i.e., it knows how the system works.
	 * 
	 * Usage: 1) Decouples clients from subsystem, 2) Provides simple interface, 3) If we want to have Subsystem
	 * layering (Business, Data and Client Services) and each of these layers provide a facade to other layer.
	 * 
	 * Structure: 1) Facade knows the subsystem, 2) It is subsystem access point, 3) Simply delegates to subsystem
	 * implementing the functionality. 4) Facade by itself never implements the functionality by itself: Client ->
	 * Facade -> Subsystem. 5) Helps extra loose coupling since Clients don't need to access the subsystem directly.
	 * 
	 * *** Most Important point *** : Clients, if needed CAN CALL the Subsystems directly too (say for performance
	 * reasons), unlike Adapter Pattern where Client is incompatible with subsystem interface so we must need an
	 * adapter!
	 * 
	 * ** Drawbacks ** Facade introduces extra programming layer so always use your judgment if facade is going to add
	 * value by abstract a complex system from a client or not.
	 * 
	 * *** Examples from Java Libraries: ServletContext, HttpSession, HttpServletRequest, HttpServletResponse, etc.
	 * https://stackoverflow.com/questions/1673841/examples-of-gof-design-patterns-in-javas-core-libraries/2707195
	 * 
	 */

	public static void main(String[] args) {

		BillingSystem billingSystem = new BillingSystem();
		InvoiceCustomerSystem invoiceCustomerSystem = new InvoiceCustomerSystem();

		Double amount = 1000.00;
		Bill bill = billingSystem.createBill(amount);
		invoiceCustomerSystem.createInvoiceForBill(bill);

		/*
		 * Underlying problem in above is, many operations are done by Client on various subsystem objects. In this
		 * case, what if 5 more operations were needed before createInvoiceForBill method be called by client? Why does
		 * Client need to know that much about subsystem and why at all do we need to repeat same code at client
		 * whenever invoice needs to be generated by Client for a transaction? Facade Pattern solves this problem as shown in "improved" package!
		 */

	}

}
