package dev.joshua_coombs.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.joshua_coombs.models.Account;
import dev.joshua_coombs.repositories.AccountDAO;
import dev.joshua_coombs.services.AccountService;
import io.javalin.http.Context;

public class AccountController {
	private static AccountService as = new AccountService(new AccountDAO());
	private static Logger log = LogManager.getLogger(AccountController.class);
	
	public static void login(Context ctx) {
		Account a = ctx.bodyAsClass(Account.class);
		Account loginEstablished = as.login(a.getUsername(), a.getPassword());
		if (a != null) {
			ctx.sessionAttribute("loginEstablished", loginEstablished);
			log.info("Session Attribute Set for Account " + loginEstablished);
			ctx.json(loginEstablished);
			ctx.status(200);
		}
	}
	
	/*
	public void createAccount(Context ctx) {
		log.info("Creating a new Account");
		ctx.status(201);
		Account accountFromRequestBody = ctx.bodyAsClass(Account.class);
		Account a = as.createAccount(accountFromRequestBody);
		ctx.json(a);
	}
	*/
	
	public static void updateReimbursementAvailable(Context ctx) {
		log.info("Updating the amount of Reimbursement available");
		ctx.status(204);
		int id = Integer.parseInt(ctx.pathParam("id"));
		Account a = ctx.bodyAsClass(Account.class);
		System.out.println(a.getReimbursementAvailable());
		as.updateReimbursementAvailable(id);
	}
	
	/*
	public void changePassword(Context ctx) {
		log.info("Changing the password of an Account");
		int id = Integer.parseInt(ctx.pathParam("id"));
		Account a = ctx.bodyAsClass(Account.class);
		System.out.println(a.getPassword());
		as.changePassword(id, a.getPassword());
	}
	*/
}
