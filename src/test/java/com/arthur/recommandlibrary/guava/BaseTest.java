package com.arthur.recommandlibrary.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {
    // 문자열 결합
    @Test
    public void joinerTest() {
        Joiner joiner = Joiner.on("; ").skipNulls();
        String join = joiner.join("Arthur", null, "BBBCCC", "DDDEE");// Arthur; BBBCCC; DDDEE
        Assert.assertTrue(join.equals("Arthur; BBBCCC; DDDEE"));

        String joinArray = Joiner.on(",").join(Arrays.asList(1, 3, 5, 13, 43, 1));
        Assert.assertTrue(joinArray.equals("1,3,5,13,43,1"));
    }

    // 문자열을 키와 값으로 연결해준다.
    @Test
    public void mapjoinerTest() {
        Joiner.MapJoiner mapJoiner = Joiner.on('&').withKeyValueSeparator("=");

        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("abcd", "sfa2");
        stringMap.put("abcd23", "sfa2asfcad");
        stringMap.put("abc3423d", "sgsfa2");

        ImmutableMap<Object, Object> immutableMap = ImmutableMap.builder()
                .putAll(stringMap)
                .build();

        String join = mapJoiner.join(immutableMap);
        Assert.assertTrue(join.equals("abcd23=sfa2asfcad&abc3423d=sgsfa2&abcd=sfa2"));
    }

    // 문자열 구분자 나누기
    @Test
    public void splitterTest() {
        String testText = "foo,bar,,   qux";

        Iterable<String> split = Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split(testText);

        /**
         * foo
         * bar
         * qux
         */
        Iterator<String> iterator = split.iterator();
        while (iterator.hasNext()){
            log.info(iterator.next());
        }
    }
}
