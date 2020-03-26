package com.self.code.statemachine.stateless;

import com.github.oxo42.stateless4j.StateMachine;
import org.junit.Test;

/**
 * @program: self-code
 * @description:
 * @author: GaoBo
 * @create: 2020/3/26
 **/
public class RunStateMachine {

    private static StateMachine<CurrentState,Trigger> stateMachine =
            new StateMachine<CurrentState, Trigger>(CurrentState.SMALL,StateConver.config);

    @Test
    public void testStateMachine(){
        StateMachine<CurrentState, Trigger> sm = StateMachineFactory.createFactory(CurrentState.SMALL, StateConver.config);
        sm.fire(Trigger.MONSTER);
        System.out.println("currentState-->"+sm.getState());
    }

    @Test
    public void testStateMachine2(){
        stateMachine.fire(Trigger.FLOWER);
        System.out.println("currentState-->"+stateMachine.getState());
    }

    @Test
    public void testStateMachine3(){
        stateMachine.fire(Trigger.MUSHROOM);
        System.out.println("currentState-->"+stateMachine.getState());
    }

    @Test
    public void testStateMachine4(){
        StateMachine<CurrentState,Trigger> stateMachine4 =
                new StateMachine<CurrentState, Trigger>(CurrentState.BIG,StateConver.config);

        stateMachine4.fire(Trigger.FLOWER);
        System.out.println("currentState-->"+stateMachine4.getState());
    }

}
