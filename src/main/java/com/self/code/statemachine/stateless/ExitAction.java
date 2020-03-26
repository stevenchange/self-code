package com.self.code.statemachine.stateless;

import com.github.oxo42.stateless4j.delegates.Action1;
import com.github.oxo42.stateless4j.transitions.Transition;

/**
 * @program: self-code
 * @description:
 * @author: GaoBo
 * @create: 2020/3/26
 **/
public class ExitAction implements Action1<Transition<CurrentState,Trigger>> {

    @Override
    public void doIt(Transition<CurrentState, Trigger> arg1) {
        System.out.println("OUT FROM :" + arg1.getSource());
    }

}
