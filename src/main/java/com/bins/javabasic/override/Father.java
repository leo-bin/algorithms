package com.bins.javabasic.override;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author leo-bin
 * @date 2020/3/9 11:43
 * @apiNote
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Father implements Serializable {

    private String name;

    public void print() {
        System.out.println(this.name);
    }
}
