package com.radhe;
public class LambdaUsingCustomInterfaces {

	public static void main(String[] args) {
		Runnable runnableFunction = () -> getFunctionBody();
		
		Thread myThread = new Thread(runnableFunction);
		myThread.run();
		greet(() -> getRunnableFunctionBody());
		
	}

	private static void getRunnableFunctionBody()
	{
		System.out.println("runnableFunction through custom functional interface");
	}
	private static void greet(RunnableFunction runnableFunction) {
		runnableFunction.foo();
	}


	private static void getFunctionBody() {
		System.out.println("runnableFunction");
	}

}
@FunctionalInterface
interface RunnableFunction {
	public void foo();
}
