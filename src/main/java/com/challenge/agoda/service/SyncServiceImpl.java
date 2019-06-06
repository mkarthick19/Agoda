package com.challenge.agoda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.challenge.agoda.exception.InvalidInputException;
import com.challenge.agoda.model.InputRequest;

// Sync Service Implementation class for Bug Tracking System.
@Service
public class SyncServiceImpl implements SyncService {

	@Autowired
	private ThirdPartyService thirdPartyService;

	private Thread syncThread = null;

	@Override
	public void syncAndUpdate(final InputRequest inputRequest) throws InvalidInputException {
		thirdPartyService.populateProjects(inputRequest);
		invokeThirdPartyService();
	}

	private void invokeThirdPartyService() {
		if (syncThread == null) {
			synchronized (SyncServiceImpl.class) {
				if (syncThread == null) {
					syncThread = new Thread(thirdPartyService);
					syncThread.start();
				}
			}
		}
	}

}
