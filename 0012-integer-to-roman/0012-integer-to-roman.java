class Solution {
    public String intToRoman(int num) {
        String ones[]={"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String tens[]={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String hunds[]={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String ths[]={"","M","MM","MMM"};
        return ths[num/1000]+hunds[(num%1000)/100]+tens[(num%100)/10]+ ones[num%10];
    }
}

// class Solution {
// public:
//     string intToRoman(int num) {
//         string ones[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
//         string tens[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
//         string hrns[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
//         string ths[]={"","M","MM","MMM"};
        
//         return ths[num/1000] + hrns[(num%1000)/100] + tens[(num%100)/10] + ones[num%10];
//     }
// };