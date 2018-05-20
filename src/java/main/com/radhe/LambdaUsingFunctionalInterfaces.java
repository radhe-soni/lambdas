package com.radhe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaUsingFunctionalInterfaces {
	private static List<Employee> employeeList;
	static {
		employeeList = Arrays.asList(
			Employee.builder().name("radhe").address(Address.builder().city("sidhi").build()).build(),
			Employee.builder().name("kishan").address(Address.builder().city("pune").build()).build(),
			Employee.builder().name("soni").address(Address.builder().city("mumbai").build()).build()
			
		);
	}

	public static void main(String[] args) {
		String message = "runnableFunction through custom functional interface";
		greet(message, msg -> printIfMessageIsLongerThan30(msg));
		
		String city = getEmployeeCityUsingSupplier(e -> "radhe".equals(e.getName()));
		System.out.println(city);
		
		Address address = getAddressWithNameUsingFunction("kishan", (e) -> e.getAddress());
		System.out.println(address);
	}

	private static Address getAddressWithNameUsingFunction(String empName, Function<Employee, Address> function) {
		return function.apply(getEmployeeWithName(empName));
	}

	private static Employee getEmployeeWithName(String empName) {
		return getEmployee(e -> "kishan".equals(e.getName()), () -> Employee.builder().build());
	}

	private static String getEmployeeCityUsingSupplier(Predicate<Employee> predicate) {
		Employee emp = getEmployee(predicate, () -> Employee.builder().build());
		return emp.getAddress().getCity();
	}

	private static Employee getEmployee(Predicate<Employee> predicate, Supplier<Employee> employeeSupplier) {
		
		return employeeList.stream().filter(predicate).findFirst().orElse(employeeSupplier.get());
	}

	private static boolean printIfMessageIsLongerThan30(String message) {
		return message.length() > 30;
	}

	private static void greet(String message, Predicate<String> predicate) {
		if (predicate.test(message)) {
			System.out.println(message);
		}
	}
}
