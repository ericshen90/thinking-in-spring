package com.eric.thinking.in.spring.ioc.overview.domain;

import com.eric.thinking.in.spring.ioc.overview.annotation.Super;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 超级用户
 *
 * @author EricShen
 * @date 2021-01-29
 */
@Getter
@Setter
@ToString(callSuper = true)
@Super
public class SuperUser extends User {
    private String address;
}
