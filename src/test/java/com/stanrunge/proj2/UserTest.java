package com.stanrunge.proj2;

import com.stanrunge.proj2.data.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    void testGetId() {
        User user = new User();
        user.setId(1);
        assertEquals(1, user.getId());
    }
}
