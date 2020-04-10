package domain;

import java.util.Arrays;

public enum Operation {
	ORDER(1),
	PAY(2),
	EXIT(3);

	private final int number;

	Operation(int number) {
		this.number = number;
	}

	public static Operation of(int inputNumber) {
		return Arrays.stream(Operation.values())
				.filter(operation -> operation.number == inputNumber)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("해당되는 번호의 operation이 없습니다."));
	}

	public boolean isOrder() {
		return this.equals(ORDER);
	}

	public boolean isPay() {
		return this.equals(PAY);
	}

	public boolean isExit() {
		return this.equals(EXIT);
	}
}
