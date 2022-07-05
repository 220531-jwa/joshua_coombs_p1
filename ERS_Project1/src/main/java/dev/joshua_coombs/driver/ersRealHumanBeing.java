package dev.joshua_coombs.driver;

import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.patch;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import dev.joshua_coombs.controllers.*;
import dev.joshua_coombs.repositories.*;
import dev.joshua_coombs.services.*;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class ersRealHumanBeing {
	public static void main(String args[]) {
		Javalin app = Javalin.create(config -> {
			config.enableCorsForOrigin("http://localhost:8090");
			config.addStaticFiles("/public/html", Location.CLASSPATH);
		});
		app.start(8090);
		app.get("/", ctx -> {
			ctx.redirect("loginPage.html");
		});
		app.routes(() -> {
			path("/login", () -> {
				put(AccountController::login);
				path("/employee", () -> {
					path("/requests", () -> {
						path("/cancel", () -> {
							patch(ReimbursementFormController::cancelReimbursementRequest);
						});
						get(ReimbursementFormController::getAllRequestsFromSpecificEmployee);
						patch(ReimbursementFormController::updateGrade);
						path("/newRequest", () -> {
							post(ReimbursementFormController::createRF);
						});
					});
					
				});
				path("/manager", () -> {
					path("/requests", () -> {
						get(ReimbursementFormController::getAllReimbursementRequests);
						patch(ReimbursementFormController::updateReimbursementStatus);
					});
				});
			});
		});
	}
}
