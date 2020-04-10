package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {

	@DisplayName("of 유효한 입력시 operation 객체를 찾아서 반환 테스트")
	@Test
	void of_When_valid_input_Return_operation() {
		assertThat(Operation.of(1)).isEqualTo(Operation.ORDER);
	}

	@DisplayName("of 유효하지 않은 입력시 예외처리")
	@Test
	void of_When_invalid_input_Throw_exception() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			Operation.of(4);
		}).withMessage("해당되는 번호의 operation이 없습니다.");
	}
}