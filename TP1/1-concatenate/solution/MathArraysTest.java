package delft;

import org.junit.jupiter.api.Test;

import static delft.MathArrays.concatenate;
import static org.assertj.core.api.Assertions.*;


class MathArraysTest {
	@Test
	void emptyArray() {
		assertThat(concatenate(new double[]{}, new double[]{1})).isEqualTo(new double[]{1});
	}

	@Test
	void nullArray() {
		assertThatThrownBy(() -> concatenate(null, new double[]{1})).isInstanceOf(NullPointerException.class);
	}

	@Test
	void nullListOfArrays() {
		assertThatThrownBy(() -> concatenate(null)).isInstanceOf(NullPointerException.class);
	}

	@Test
	void zeroArray() {
		assertThat(concatenate()).isEmpty();
	}

	@Test
	void oneArrayWithOneElement() {
		assertThat(concatenate(new double[]{1})).isEqualTo(new double[]{1});
	}

	@Test
	void oneArrayWithMultipleElements() {
		assertThat(concatenate(new double[]{1,2,3})).isEqualTo(new double[]{1,2,3});
	}

	@Test
	void twoArraysWithMultipleElements() {
		assertThat(concatenate(new double[]{1,2,3}, new double[]{4,5,6})).isEqualTo(new double[]{1,2,3,4,5,6});
	}

	@Test
	void multipleArraysWithMultipleElements() {
		assertThat(concatenate(new double[]{1,2}, new double[]{3,4}, new double[] {5,5,3})).isEqualTo(new double[]{1,2,3,4,5,5,3});
	}
}
