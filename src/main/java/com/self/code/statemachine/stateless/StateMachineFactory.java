package com.self.code.statemachine.stateless;

import com.github.oxo42.stateless4j.StateMachine;
import com.github.oxo42.stateless4j.StateMachineConfig;

/**
 * @program: self-code
 * @description:
 * @author: GaoBo
 * @create: 2020/3/26
 **/
public class StateMachineFactory {

    public static StateMachine<CurrentState, Trigger> createFactory(CurrentState currentState,
                                                                   StateMachineConfig config){
        return new StateMachine<CurrentState, Trigger>(currentState, config);
    }


}
