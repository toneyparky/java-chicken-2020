package domain.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class AmountTest {

	@DisplayName("Amount 정상 생성 테스트")
	@Test
	void create() {
		assertThat(new Amount(10)).isInstanceOf(Amount.class);
	}

	@DisplayName("Amount 예외처리 테스트 (0 이하 혹은 100 이상)")
	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 100, 101})
	void create_When_invalid_input_Throw_exception(int input) {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Amount(input);
		}).withMessage("총 주문량은 1-99 사이여야합니다.");
	}

	@DisplayName("add 유효한 입력시 정상 동작 테스트")
	@Test
	void add_When_normal_input_Add_input() {
		Amount amount = new Amount(10);
		amount.add(amount);
		assertThat(amount.getAmount()).isEqualTo(20);
	}

	@DisplayName("add 총 합이 초과되는 경우 예외처리")
	@Test
	void add_When_over_bound_input_Throw_exception() {
		Amount amount = new Amount(10);
		Amount other = new Amount(99);
		assertThatIllegalArgumentException().isThrownBy(() -> {
			amount.add(other);
		}).withMessage("총 주문량은 1-99 사이여야합니다.");
	}
}