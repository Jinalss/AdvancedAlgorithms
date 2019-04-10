import java.util.Stack;

public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {

        int result = 0;
        int l = 0;
        Stack stk = new Stack();
        stk.push(-1);
        for(int i = 0; i<s.length(); i++){

            if(s.charAt(i) == '('){

                stk.push(i);

            }else{

                if(!stk.isEmpty())
                    stk.pop();

                if(stk.isEmpty()){

                    stk.push(i);

                }else{

                    l = i - (int)stk.peek();
                    //stk.pop();
                    if( l > result )
                        result = l;
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(longestValidParentheses(")()())"));

    }

}
