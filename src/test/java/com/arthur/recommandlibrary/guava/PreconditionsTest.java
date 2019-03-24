package com.arthur.recommandlibrary.guava;

import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Guava 유틸리티 예제
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class PreconditionsTest {

    // message가 null일때 예외를 발생시켜준다.
    @Test(expected = NullPointerException.class)
    public void checkNotNullTest() {
        String message = null;
        Preconditions.checkNotNull(message);
    }

    // 전달된 Aurgments에 대한 검증을 수행
    @Test(expected = IllegalArgumentException.class)
    public void checkArgumentTest() {
        int value = 3;

        // java.lang.IllegalArgumentException: 이런 3의 값에대한 에러가 발생했네요.
        Preconditions.checkArgument(value > 5, "이런 %s의 값에대한 에러가 발생했네요.", value);
    }

    // 전달된 Aurgments에 대한 검증을 수행
    @Test(expected = IllegalStateException.class)
    public void checkStateTest() {
        // java.lang.IllegalStateException: 값이 올바르지 않아요
        Preconditions.checkState(3 > 5, "값이 올바르지 않아요");
    }
}
