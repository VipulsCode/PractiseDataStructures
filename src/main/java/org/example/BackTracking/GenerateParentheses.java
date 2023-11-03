package org.example.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    /** GO THROUGH JUST EXPLANATION, NOT THE CODE, it will be defined in form of tree, the recursion i mean, and you'll understand the below condition
     * https://www.youtube.com/watch?v=s9fokUqJ76A
     */

    /** To solve this problem we will have to consider 3 condition
    1 condn... At Starting , we cannot start with closing parenthesis, it has to always start with open parenthesis. and OPEN
     parenthesis can only be placed when Open Parenthesis count (which will be maintained, to count of number of open
     parenthesis considered) the count is lesser than "n", so the count starts from 0

    2nd condn: Now the close Parenthesis can only be considered when count of close Parenthesis is lesser than count of
     Open parenthesis, i mean if there's already an open parenthesis there, only then we can have closed parenthesis.

    3rd condn: the executing will come to halt if both the count, the open parenthesis count and close parenthesis count
     is equal to n.

     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String parenthesis = ""; // initially globally it's empty, maintained it globally because during the recursion the
        //  i need to concat the current parenthesis with the older considered parenthesis

        combinationThroughBackTracking(0, 0, parenthesis, res, n);
        return res; // collecting all the patterns from the below back tracking method, hence res was defined globally

    }

    public void combinationThroughBackTracking(int openParenthesisCount, int closedParenthesisCount, String parenthesisPattern,
                                               List<String> res, int n) {

        if (openParenthesisCount == n && closedParenthesisCount == n) { // 3rd condition
            res.add(parenthesisPattern); // Adding the collected parenthesis pattern to the result list, once the recursion reaches it's
            // breaking condition
            return;
        }

        if (openParenthesisCount < n) {
            combinationThroughBackTracking(openParenthesisCount + 1, closedParenthesisCount, parenthesisPattern + "(", res, n);
            // so here i am going deep till i finish up the consideration of open parenthesis and at every recursion i am concatinating the old parenthesis,
            // with the current one, the counter is used to keep the track how much of open parenthesis have we considered, This is condition 1, as mentioned on top, before
            // starting the problem
        }

        if (closedParenthesisCount < openParenthesisCount) {
            combinationThroughBackTracking(openParenthesisCount, closedParenthesisCount + 1, parenthesisPattern + ")", res, n);
            // Executing condition 2
        }
    }
}
