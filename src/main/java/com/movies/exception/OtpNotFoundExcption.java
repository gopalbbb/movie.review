package com.movies.exception;

public class OtpNotFoundExcption extends Exception{
	 

		private static final long serialVersionUID = 5514921199322765907L;
		
		String message;

		public OtpNotFoundExcption (String message) {
			super();
			this.message = message;
		}

		public OtpNotFoundExcption() {
			super();
			this.message = "OTP is not verified";
		}
		
		

	}

