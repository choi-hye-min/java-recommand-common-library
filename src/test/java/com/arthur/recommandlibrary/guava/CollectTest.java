package com.arthur.recommandlibrary.guava;

import com.google.common.collect.Range;
import com.google.common.primitives.Ints;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectTest {

    // Range 숫자 값에 대한 검증, 혹은 조건에 따른 처리 시에 많이 활용
    @Test
    public void rangeTest() {
        int testValue = 5;

        // 3 <= testValue >= 10 : 3이상 10이하여야한다.
        boolean contains = Range.closed(3, 10).contains(testValue);
        Assert.assertTrue(contains);

        // testValue <= 10 : 10이하
        boolean contains1 = Range.lessThan(10).contains(testValue);
        Assert.assertTrue(contains1);

        // 1 <= [1,2,3] >= 4 : 범위안에 배열들의 값이 포함되어있어야한다.
        boolean containsAll = Range.closed(1, 4).containsAll(Ints.asList(1, 2, 3));
        Assert.assertTrue(containsAll);
    }
}
