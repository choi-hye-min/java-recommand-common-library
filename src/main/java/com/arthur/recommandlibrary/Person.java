package com.arthur.recommandlibrary;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import lombok.Getter;

@Getter
public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("age", age)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equal(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, age);
    }
}
