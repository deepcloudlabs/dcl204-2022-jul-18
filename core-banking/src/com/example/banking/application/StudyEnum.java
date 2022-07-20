package com.example.banking.application;

import com.example.banking.domain.AccountStatus;

public class StudyEnum {

	public static void main(String[] args) {
		for(var status : AccountStatus.values()) {
			System.out.println("%8s %1d %3d".formatted(status.name(),status.ordinal(),status.getCode()));
		}

	}

}
