package javaapplication109;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
class Node {
    //Dugum sınıfı
    
    String value;
    Node left, right;
 
    Node(String item) {
        value = item;
        left = right = null;
    }
}
class ExpressionTree {
    //Ağaç sınıfı
    int sa;
    int top;
    ExpressionTree(int top){
       this.sa=0;
       this.top=top;
    }
    boolean isOperator(String c) {
        if (c.charAt(0) == '+' || c.charAt(0) == '-'
                || c.charAt(0) == '*' || c.charAt(0) == '/'
                || c.charAt(0) == '^') {
            return true;
        }
        return false;
    }
   int Operator(String c){
        if(c.charAt(0)=='+'){
            return 1;
        }
        else if(c.charAt(0)=='-'){
            return 2;
        }
           else if(c.charAt(0)=='*'){
            return 3;
        }
              else if(c.charAt(0)=='^'){
           return 5;
        }
           else {
               return 4;
           }
    }
    
    void inorder(Node t) {
        if (t != null) {
            inorder(t.left);
            System.out.print(t.value + " ");
            inorder(t.right);
        }
    }
      void postorderBas(Node node) {
        if (node == null) {
            return;
        }
        postorderBas(node.left);
        postorderBas(node.right);
        System.out.print(node.value + "");
    }
    
    void postorder(Node t,Stack<Node> st) {
        if (t == null) {
            return;
        }
        postorder(t.left,st);
        postorder(t.right,st);
        if(!isOperator(t.value)){
           st.push(t);
           ++this.sa;
        }
        else{
            ++this.sa;
            int a,b;
            int s;
            Node tmp=st.pop();
            a=Integer.parseInt(tmp.value);
             tmp=st.pop();
            b=Integer.parseInt(tmp.value);
            if(Operator(t.value)==1){
                s=b+a;
            }
            else if(Operator(t.value)==2){
                s=b-a;
            }
             else if(Operator(t.value)==3){
                s=a*b;
            }
              else if(Operator(t.value)==4){
                s=b/a;
            }
              else {
                s=(int) Math.pow(b, a);
              }
            String w=""+s;
            tmp=new Node(w);
            st.push(tmp);         
        }  
        if(sa==top){
                   System.out.println("Sonuç : "+st.peek().value);
        } 
    }
    Node constructTree(String postfix[]) {
        Stack<Node> st = new Stack<Node>();
        Node t, t1, t2;
        for (int i = 0; i < postfix.length; i++) {
            if (!isOperator(postfix[i])) {
                t = new Node(postfix[i]);
                st.push(t);
            } else 
            {
                t = new Node(postfix[i]);
                t1 = st.pop();     
                t2 = st.pop();
                t.right = t1;
                t.left = t2;
                st.push(t);
            }
        }
        t = st.peek();
        st.pop();
 
        return t;
    }
}
public class JavaApplication109 {
    //infix ifadeyi postfix yapma işlemleri
     public static int getPreference(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        } else {
            return -1;
        }
    }
     public static  boolean isOperator(String c) {
        if (c.charAt(0) == '+' || c.charAt(0) == '-'
                || c.charAt(0) == '*' || c.charAt(0) == '/'
                || c.charAt(0) == '^') {
            return true;
        }
        return false;
    }
   public static List<String> getPostFixString(String s) {
        Stack<Character> stack = new Stack<>();
        List<String> postFixList = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);
            if (word == ' ') {
                continue;
            }
            if (word == '(') {
                stack.push(word);
                flag = false;
            } else if (word == ')') {
                flag = false;
                while (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                        break;
                    } else {
                        postFixList.add(stack.pop() + "");
                    }
                }
            } else if (word == '+' || word == '-' || word == '*' || word == '/') {
                flag = false;
                if (stack.isEmpty()) {
                    stack.push(word);
                } else {
                    while (!stack.isEmpty() && getPreference(stack.peek()) >= getPreference(word)) {
                        postFixList.add(stack.pop() + "");
                    }
                    stack.push(word);
                }
            } else {
                if (flag) {
                    String lastNumber = postFixList.get(postFixList.size() - 1);
                    lastNumber += word;
                    postFixList.set(postFixList.size() - 1, lastNumber);
                } else {
                    postFixList.add(word + "");
                }
                flag = true;
            }
        }
        while (!stack.isEmpty()) {
            postFixList.add(stack.pop() + "");
        }
        return postFixList;
    }

    public static void main(String[] args) {
        List<String> ls = new ArrayList<String>();
        String w = "52+((5*6)/8)+5";
        ls = getPostFixString(w);
        String e = "";

        String[] c=new String[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
             c[i]=ls.get(i);
        }
        ExpressionTree et = new ExpressionTree(c.length);
        Node root = et.constructTree(c);
         Stack<Node> st = new Stack<Node>();
        System.out.print("İnorder gösterimi ");
         et.inorder(root);
         System.out.println("");
         System.out.print("Preorder Gösterimi ");
         System.out.println(Arrays.toString(c));
         et.postorder(root,st);
       
    }

}
