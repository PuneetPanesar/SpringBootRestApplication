package com.amdocs.gradleSpring.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class errorDetails {

	String Message;
	int statusCode;
	LocalDateTime datetime;
	
}
