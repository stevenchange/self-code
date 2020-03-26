package com.self.code.statemachine.stateless;

/**
 * @program: self-code
 * @description:
 * @author: GaoBo
 * @create: 2020/3/26
 **/
public enum CurrentState {

    /**
     * 初始化时小形态
     */
    SMALL,
    /**
     * 吃到一个蘑菇时的大形态
     */
    BIG,
    /**
     * 吃到花朵,可攻击形态
     */
    ATTACH,
    /**
     * godead
     */
    DEAD

}
