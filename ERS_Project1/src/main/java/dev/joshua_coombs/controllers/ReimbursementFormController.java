package dev.joshua_coombs.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.joshua_coombs.models.*;
import dev.joshua_coombs.repositories.ReimbursementFormDAO;
import dev.joshua_coombs.services.*;
import io.javalin.http.Context;

public class ReimbursementFormController {
	private static ReimbursementFormService rfs = new ReimbursementFormService(new ReimbursementFormDAO());
	private static Logger log = LogManager.getLogger(ReimbursementFormController.class);
	
	public static void createRF(Context ctx) {
		log.info("Creating a new ReimbursementForm");
		ctx.status(201);
		ReimbursementForm rfFromRequestBody = ctx.bodyAsClass(ReimbursementForm.class);
		ReimbursementForm rf = rfs.createRF(rfFromRequestBody);
		ctx.json(rf);
	}
	
	public static void getAllReimbursementRequests(Context ctx) {
		log.info("Getting all ReimbursementForm requests");
		ctx.status(200);
		List<ReimbursementForm> rfForms = rfs.getAllReimbursementRequests();
		ctx.json(rfForms);
	}
	
	public static void getSpecificReimbursementRequest(Context ctx) {
		log.info("Getting specific ReimbursementForm request");
		ctx.status(200);
		int rId = Integer.parseInt(ctx.pathParam("r_id"));
		ReimbursementForm rf = rfs.getSpecificReimbursementRequest(rId);
		ctx.json(rf);
	}
	
	public static void getAllRequestsFromSpecificEmployee(Context ctx) {
		log.info("Getting all ReimbursementForm requests from a specific employee");
		ctx.status(200);
		int eId = Integer.parseInt(ctx.pathParam("e_id"));
		List<ReimbursementForm> rfForms = rfs.getAllRequestsFromSpecificEmployee(eId);
		ctx.json(rfForms);
	}
	
	public static void cancelReimbursementRequest(Context ctx) {
		log.info("Cancelling a Reimbursement request");
		ctx.status(204);
		int rId = Integer.parseInt(ctx.pathParam("r_id"));
		ReimbursementForm rf = rfs.cancelReimbursementRequest(rId);
		ctx.json(rf);
	}
	
	public static void updateReimbursementStatus(Context ctx) {
		log.info("Updating a Reimbursement status");
		ctx.status(204);
		String updatedStatus = ctx.pathParam("r_status");
		int rId = Integer.parseInt(ctx.pathParam("r_id"));
		ReimbursementForm rf = rfs.updateReimbursementStatus(updatedStatus, rId);
		ctx.json(rf);
	}
	
	public static void updateReimbursementAmount(Context ctx) {
		log.info("Updating a Reimbursement amount");
		ctx.status(204);
		int updatedAmount = Integer.parseInt(ctx.pathParam("r_amount"));
		int rId = Integer.parseInt(ctx.pathParam("r_id"));
		ReimbursementForm rf = rfs.updateReimbursementAmount(updatedAmount, rId);
		ctx.json(rf);
	}
	public static void updateGrade(Context ctx) {
		log.info("Updating a grade");
		ctx.status(204);
		String newGrade = ctx.pathParam("grade");
		int rId = Integer.parseInt(ctx.pathParam("r_id"));
		ReimbursementForm rf = rfs.updateReimbursementStatus(newGrade, rId);
		ctx.json(rf);
	}
}
