package com.self.code.statemachine.stateless;

import com.github.oxo42.stateless4j.StateMachine;
import org.junit.Test;

/**
 * @program: self-code
 * @description:
 * @author: GaoBo
 * @create: 2020/3/26
 **/
public class RunStateMachine2 {

    private static StateMachine<CurrentState,Trigger> stateMachine =
            new StateMachine<CurrentState, Trigger>(CurrentState.SMALL,StateConver2.config);

    @Test
    public void testStateMachine(){
        stateMachine.fire(Trigger.FLOWER);
        System.out.println("currentState-->"+stateMachine.getState());
    }

    @Test
    public void testStateMachine2(){
        stateMachine.fire(Trigger.FLOWER);
        System.out.println("currentState-->"+stateMachine.getState());
        stateMachine.fire(Trigger.MONSTER);
    }

}
