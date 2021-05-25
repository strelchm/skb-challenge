package ru.strelchm.skb;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceAnswer<T, V> {
    private T t;
    private V v;
}
