package br.com.lfrancisco.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.lfrancisco.converters.NumberConverter;
import br.com.lfrancisco.exceptions.UnsuportedMathOperationException;
import br.com.lfrancisco.math.SimpleMath;

@RestController
public class MathController {

	private final SimpleMath simpleMath = new SimpleMath();
	
	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}

		return simpleMath.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@GetMapping("/subtraction/{numberOne}/{numberTwo}")
	public Double subtraction(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}

		return simpleMath.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping("/multiplication/{numberOne}/{numberTwo}")
	public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}

		return simpleMath.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping("/division/{numberOne}/{numberTwo}")
	public Double division(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}

		return simpleMath.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping("/mean/{numberOne}/{numberTwo}")
	public Double mean(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}

		return simpleMath.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping("/squareRoot/{number}")
	public Double squareRoot(@PathVariable(value = "number") String number) throws Exception {

		if (!NumberConverter.isNumeric(number)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}

		return simpleMath.squareRoot(NumberConverter.convertToDouble(number));
	}

}
