package com.eric.thinking.in.spring.ioc.overview.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户
 *
 * @author EricShen
 * @date 2021-01-28
 */
@Getter
@Setter
@ToString
public class User {
    private Long id;
    private String name;
}
