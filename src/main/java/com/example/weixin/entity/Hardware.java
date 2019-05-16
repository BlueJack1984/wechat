package com.example.weixin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 关联硬件实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hardware implements Serializable {

    private Long id;
    private String macAddress;
    private String mainBoardName;
}
