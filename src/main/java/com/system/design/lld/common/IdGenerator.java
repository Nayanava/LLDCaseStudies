package com.system.design.lld.common;
/**
 * @author nayanava
 */

import java.util.UUID;

public class IdGenerator {
    public static String generate(String startsWith) {
        return String.format(startsWith + UUID.randomUUID());
    }
}
