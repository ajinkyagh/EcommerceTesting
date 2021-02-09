package flipkartPageObjModel;

public class StringCheck {
    public static void main(String[] args){
        String amount="₹14,123";
        char[] amt=new char[amount.length()];
        char[] amt1=new char[amount.length()];
        int j=0;
        for (int i=0;i<amount.length();i++){
            amt[i]=amount.charAt(i);

        }
        for(int i=0;i<amt.length;i++){
            if (amt[i] != '₹' && amt[i] != ',') {
                amt1[j]=amt[i];
                j++;
            }

        }
        long amounttoString=Long.parseLong(String.valueOf(amt1).trim());
        System.out.println(amounttoString);
    }

}
