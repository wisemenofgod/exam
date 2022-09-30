package com.htl.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * @author hehehe
 * @ClassName SHATest
 * @Description TODO
 * @date 2022/5/3 0003 2:11
 * @Version 1.0
 */

public class SHATest {
    @Test
    public void shaTest(){
        System.out.println(DigestUtils.sha256Hex("123456"));
    }
}
