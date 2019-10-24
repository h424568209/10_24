public class LEE {
    /**
     * 给定一个字符串，返回字符串中的数，
     * 字符串是字母开头的 返回0
     * 字符串是空格开头的 跳过空格
     * 若大于int的最大值 返回int最大值/int最小值
     * 设置一个标志符号的flag 进行正负判断
     * @param str 字符串
     * @return 字符串中的数
     */
    private static int myAtoi(String str) {
        int first = 1;
        int ans = 0;
        int flag = 1;
        int len = str.length();
        for(int i = 0;i<len;i++){
            char temp = str.charAt(i);
           if(first ==1 ){
               if(temp==' '){
                   continue;
               }else if(temp =='+'){
               }else if(temp == '-'){
                   flag = -1;
               }else if(temp>='0'&&temp <= '9'){
                   ans = ans*10+(temp-'0');
               } else{
                   return 0;
               }
               first = 0;
           }else{
               if(temp>='0'&&temp<='9'){
                   if(flag==1 && (ans>Integer.MAX_VALUE/10||ans==Integer.MAX_VALUE/10&&temp>'7')){
                       return Integer.MAX_VALUE;
                   }
                   if(flag ==-1 &&(Integer.MAX_VALUE/10<ans||Integer.MAX_VALUE==ans/10&&temp>'8')){
                       return Integer.MIN_VALUE;
                   }
                   ans = ans*10+(temp-'0');
               }else{
                   return ans*flag;
               }
           }
        }
        return ans*flag;
    }

    public static void main(String[] args) {
        String s =" -42";
        System.out.println(LEE.myAtoi(s));
    }
}
