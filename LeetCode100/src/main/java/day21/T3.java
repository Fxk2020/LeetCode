package day21;


import java.util.ArrayList;
import java.util.List;

public class T3 {

    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        backtrack(new StringBuilder(), res, n, 0, 0);
        return res;
    }

    private void backtrack(StringBuilder stringBuilder, List<String> res, int max, int open, int close) {

        if (stringBuilder.length()==2*max){
            res.add(stringBuilder.toString());
            return;
        }

        if (open<max){
            //1
            stringBuilder.append('(');
            //2
            backtrack(stringBuilder, res, max, open+1, close);
            //3
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

        if (close<open){
            //
            stringBuilder.append(')');
            //
            backtrack(stringBuilder, res, max, open, close+1);
            //
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }


    }


}
