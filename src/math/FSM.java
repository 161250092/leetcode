package math;

import java.util.ArrayList;
import java.util.List;

public class FSM {
    public boolean match(char[] str, char[] pattern)
    {
        return match(str,0,pattern,0);
    }


    public boolean match(char[] str,int strIndex,char[] pattern,int patternIndex){

//       两边同时匹配结束
        if(strIndex == str.length&&patternIndex == pattern.length) return true;
//        字符串有剩余但是正则表达式已经匹配结束
        if(strIndex<str.length&&patternIndex>=pattern.length) return false;
//        字符串结束但是正则表达式未结束
        if(strIndex==str.length&&patternIndex<pattern.length) {
            while(patternIndex<pattern.length){
                if(pattern[patternIndex]!='*'&&(patternIndex+1>=pattern.length||pattern[patternIndex+1]!='*'))
                    return false;
                patternIndex++;
            }
            return true;
        }
//System.out.println(str[strIndex]+"  "+pattern[patternIndex]);
//      字符串和正则表达式都未结束

//        两者相同  or pattern[index] =='.'
        if(patternIndex==pattern.length-1) {
            if (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')
                return match(str, strIndex + 1, pattern, patternIndex + 1);

            else return false;
        }

        if(pattern[patternIndex+1]!='*')
            if(str[strIndex]==pattern[patternIndex]||pattern[patternIndex]=='.')
                return match(str,strIndex+1,pattern,patternIndex+1);

        if(pattern[patternIndex+1]=='*'){
            if(pattern[patternIndex]==str[strIndex]||pattern[patternIndex]=='.')
//1  或多  ,0,
                return match(str,strIndex+1,pattern,patternIndex)||match(str,strIndex,pattern,patternIndex+2);
//          ||match(str,strIndex+1,pattern,patternIndex+2)
            if(pattern[patternIndex]!=str[strIndex])
                return match(str,strIndex,pattern,patternIndex+2);

        }

        if(pattern[patternIndex]!=str[strIndex])
            return false;

        return false;

    }

//    + - . e  0-10


    //  e 后只可以是整数
    public boolean isNumeric(char[] str) {
        if(str==null||str.length==0) return false;
        if(str[0]=='+'||str[0]=='-'&&str.length>=2)
            return state1(str,1);

        if(Character.isDigit(str[0]))
            return state1(str,0);

        return false;

    }

    public boolean state1(char[] str,int index){
        if(index==str.length)
            return true;

//        如果是整数继续状态1的循环
        if(Character.isDigit(str[index]))
            return state1(str,index+1);
//   index<str.length-1  使得 . E e 后面必定有  char
        if(str[index]=='.'&&index<str.length-1)
            return state2(str,index+1);

        if((str[index]=='e'||str[index]=='E')&&index<str.length-1)
            return state3(str,index+1,true);

        return false;
    }


    public boolean state2(char[] str,int index){
        if(index==str.length)
            return true;
        if(Character.isDigit(str[index]))
            return state2(str,index+1);

        if((str[index]=='e'||str[index]=='E')&&index<str.length-1)
            return state3(str,index+1,true);


        return false;
    }


    public  boolean state3(char[] str,int index,boolean startFlg){
        if(index==str.length)
            return true;

        if(startFlg){
            if((str[index]=='+'||str[index]=='-')&&index<str.length-1)
                return state3(str,index+1,false);
            if(Character.isDigit(str[index]))
                return state3(str,index+1,false);
            return  false;
        }

        if(Character.isDigit(str[index]))
            return state3(str,index+1,false);

        return false;

    }


    List<Character> charList = new ArrayList<>();
    List<Character> removeList = new ArrayList<>();
    public void Insert(char ch)
    {
        if(!charList.contains(ch))
            charList.add(ch);
        else {
            removeList.add(ch);
        }

    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {

        for(char ch:removeList){
            Character c = ch;
            charList.remove(c);
        }

        if(charList.isEmpty()) {
            return '#';
        }
        else {
            return charList.get(0);
        }
    }
}
