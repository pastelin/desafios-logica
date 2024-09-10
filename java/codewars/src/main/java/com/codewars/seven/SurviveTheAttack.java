package com.codewars.seven;

import java.util.stream.IntStream;
import static java.util.stream.IntStream.of;

public class SurviveTheAttack {

    public static boolean block(int[] attackers, int[] defenders){

        boolean isSurvivor = false;
        int defendersSurvivors = defenders.length;
        int attackersSurvivors = attackers.length;

        for(int i=0; i < attackers.length; i++) {
            if(defenders.length > i) {
                if(attackers[i] > defenders[i]) {
                    defendersSurvivors--;
                } else if(attackers[i] == defenders[i]) {
                    defendersSurvivors--;
                    attackersSurvivors--;
                } else {
                    attackersSurvivors--;
                }
            }
        }

        if(defendersSurvivors > attackersSurvivors) {
            isSurvivor = true;
        } else if(defendersSurvivors == attackersSurvivors) {
            int defendersDamage = IntStream.of(defenders).sum();
            int attackersDamage = IntStream.of(attackers).sum();

            if(defendersDamage > attackersDamage || defendersDamage == attackersDamage) {
                isSurvivor = true;
            }
        }

        return isSurvivor;
    }

    static boolean blockOptimaze(int[] attackers, int[] defenders) {
        int survived = defenders.length - attackers.length;
        for (int i = 0; i < Math.min(defenders.length, attackers.length); i++) {
            survived += Math.signum(defenders[i] - attackers[i]);
        }
        return survived > 0 || survived == 0 && of(defenders).sum() >= of(attackers).sum();
    }
}
