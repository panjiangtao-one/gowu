package com.gowu.account.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author EiletXie
 * @Since 2020/3/18 23:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Long id;

    private Long userId;

    private BigDecimal total;

    private BigDecimal used;

    private BigDecimal  residue;
}
