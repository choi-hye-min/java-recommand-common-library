package com.arthur.recommandlibrary.guava;

import com.arthur.recommandlibrary.Person;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CachesTest {
    private Map<String, Person> personMap;

    // 캐시테스트를 위한 샘플 데이터 준비
    @Before
    public void setUp() {
        personMap = new HashMap();

        personMap.put("P999", new Person("robot", 22));
        personMap.put("P1000", new Person("arthur", 33));
    }

    // 캐시의 기본적인 형태는 키/값 형태의 데이터 구조로 표현
    @Test
    public void cacheBuilderTest() throws InterruptedException {
        LoadingCache<String, Person> loadingCache = CacheBuilder.newBuilder()
                .maximumSize(5)
                .expireAfterWrite(1, TimeUnit.SECONDS)
                .build(new CacheLoader<String, Person>() {
                           @Override
                           public Person load(String key) throws Exception {
                               log.info("# CacheLoader Start - "+key);
                               Thread.sleep(1500);
                               return personMap.get(key);
                           }
                       }
                );

        loadingCache.putAll(personMap); // person데이터들을 전부 캐시에 올린다.

        log.info(loadingCache.getUnchecked("P1000").toString()); // 캐시에서 가져옴

        Thread.sleep(3500); // 3.5초 대기 그동안 캐시가 사라지기때문에 CacheLoader에서 다시 불러온다

        log.info(loadingCache.getUnchecked("P1000").toString()); // personMap에서 가져옴
    }
}
