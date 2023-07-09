package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class ResponceApi {
		private String message;
		private LocalDateTime timeStamp;
		public ResponceApi(String message) {
			super();
			this.message = message;
			this.timeStamp = LocalDateTime.now();
		}
		
		
}
