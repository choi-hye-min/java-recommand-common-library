package com.arthur.recommandlibrary.guava;

import com.google.common.base.MoreObjects;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Guava 유틸리티 예제
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MoreObjectsTest {
    /**
     * Object를 String으로 변환해준다. 보통 메모리 주소가 찍히는데 구아바 사용하는게 더 좋다!
     */
    @Test
    public void MoreObjectstoStringHelperTest() {
        // output : GuavaLibraryTest{}
        MoreObjects
                .toStringHelper(this)
                .toString();

        // output : GuavaLibraryTest{name=arthur}
        MoreObjects
                .toStringHelper(this)
                .add("name", "arthur")
                .toString();

        // output : GuavaLibraryTest{33, aa}
        MoreObjects.toStringHelper("")
                .addValue(33)
                .addValue("aa")
                .toString();

        // output : GuavaLibraryTest{33}
        MoreObjects.toStringHelper("")
                .omitNullValues()
                .addValue(33)
                .addValue(null)
                .toString();

        // 둘중에 null이 아닌값을 리턴한다
        String firstString = null;
        String secondString = "Hello";
        MoreObjects.firstNonNull(firstString, secondString);
    }
}
