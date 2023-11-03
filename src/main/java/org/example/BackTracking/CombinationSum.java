package org.example.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * The intuition behind solving this problem is , from the given candidate array select index 0 , from here there are two either we can pick this index value or we cannot
 * pick this index val, we will solve for both, so we take a recursion function where we will see if the target is greater than the candidate[indexed] value , initially index value
 * will start from 0, and we take candidate[0], and as given in the question it is said that the same index value can be picked multiple times, so the index value will
 * be incremented only when the index is not picked, so for not picking, the rule is target (and the target which i am saying will keep on changing, you see the code you'll understand)
 * so for not picking up the condition is  if the current target < current candidate[indexed] value, so if we do not pick it up we increment the index by 1 , but do not change the
 * current target (normal recursion for this point).
 * Now we maintain the data structure and fill it when we pick the index at every recursion, so at every step if only picked put datastructure.add(candidate[index]), else do not
 * populate data structure.
 *
 * Now the base condition will be if index == candidates.length , make sure it's not candidates.length - 1, as soon as the index reaches the length we check if target == 0,
 * why target == 0, coz at every recursion, if picked we are trying to minus the current target with index, so target decreases, and once index reaches to candidates length size
 * if target == 0, then we can say this datastructure accumulated data forms the combination (as u sum the data structure accumulated data it will be equal to orginal target, which
 * was provided during question)
 *
 * Now collect that data structure value in a res list , i mean deep copy it , as ill be changing the data structure value,by deleting the last value of datastructure,
 * every time the base condition is reached. So that it can occupy different combination data.
 *
 * Now return the res List
 *
 */

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> resList = new ArrayList<>();

        List<Integer> dataStructure = new ArrayList<>();

        int index = 0;

        createCombination(index, dataStructure, resList, candidates, target);
        return resList;
    }

    public void createCombination(int index, List<Integer> dataStructure, List<List<Integer>> resList, int[] candidates,
                                  int target) {
        // base condition
        if (index == candidates.length) {
            if (target == 0) {
                resList.add(new ArrayList<>(dataStructure)); // deep copy
                return;
            }
        }

        if (target >= candidates[index]) {
            target = target - candidates[index];
            dataStructure.add(candidates[index]);

            createCombination(index, dataStructure, resList, candidates, target); // calling recursion, and since it;s picked up we can utilise same index again and again as per question
            // only condition in the next combination list at least one value in it should be different, to say difft combination.

            dataStructure.remove(dataStructure.size() - 1); // after finishing the base condition if and only if it's picked up, so that it can have different combination
        }

        createCombination(index + 1, dataStructure, resList, candidates, target); // normal recursion, only index + 1, here index gets incremented

    }
}
