package com.Travel.butler.service;

import java.util.List;
import java.util.Set;

public interface RedisService {

    public boolean set(final String key, Integer value);

    public boolean set(final String key, String value, Integer expireTime);

    public boolean incrBy(String key, long integer);

    public void remove(final String... keys);

    public void removePattern(final String pattern);

    public void remove(final String key);

    public boolean exists(final String key);

    public Integer get(final String key);

    public void hmSet(String key, Object hashKey, Object value);

    public Object hmGet(String key, Object hashKey);

    public void lPush(String k,Object v);

    public List<Object> lRange(String k, long l, long l1);

    public void add(String key,Object value);

    public Set<Object> setMembers(String key);

    public void zAdd(String key,Object value,double scoure);

    public Set<Object> rangeByScore(String key,double scoure,double scoure1);

}
