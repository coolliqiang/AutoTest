package com.test.autotest.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User1 {
    /**
     * 接口层面维护的实例
     *
     * */
    private String id;
    private String username;
    private String password;
}
