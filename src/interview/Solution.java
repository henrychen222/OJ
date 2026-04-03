package interview;

import java.util.*;

public class Solution {


    /*
    New question to calculate the cashback for expense list.
    // 01 GROCERIES 6%
    // 02 RESTAURANT 2%
    // 05 FUEL 3%
    // 06 TRAVEL 3%
    // 07 OTHERS 1%
    // First Attribute is the date in MMDD format.
    //Second Attribute is the merchant name.
    //Third Attribute is the amount spent.
    // Fourth Attribute is the category of the expense.
        - Categoty can be 01, 02, 05, 06, 07 or null. If null it is considered as 07 OTHERS.

        // Write a method to calculate the total cashback for each category.
        // Generate a Credit Card Statement for the user with the total amount and Cashback earnt.
        // Also there is a $120 annual fee that is calculated monthly. Add that to the Credit card statement.
     */


    static final String[] INPUTS_CASHBACK = {"0101,Walmart,100,01",
            "0102,Chipotle,50,02", "0103,Starbucks,30,null", "0104,7-Eleven,20,null",
            "0105,IHOP,10,null", "0106,Olive Garden,200,02", "0107,Panera Bread,150,null",
            "0108,Dunkin',80,null", "0109,Office Depot,60,null", "0110,Home Depot,40,null",
            "0111,Shell,120,05", "0112,Expedia,300,06", "0113,Red Lobster,90,02",
            "0114,Kroger,250,01", "0115,Marriott,400,06", "0116,Chevron,180,05",
            "0117,Best Buy,500,07", "0118,Macy's,220,07", "0119,Target,130,01", "0120,McDonald's,60,02"};

    static Map<String, Double> categoryMap = new HashMap<>() {{
        put("01", 0.06);
        put("02", 0.02);
        put("05", 0.03);
        put("06", 0.03);
        put("07", 0.01);
    }};

    // 0101,Walmart,100,01
    static public class Info {
        String Date;
        String merchant;
        String amount;
        String category;
        Double cashBack;

        public String toString(){
           return super.toString();
        }
    }


    public static void main(String[] args) {
        List<Info> data = new ArrayList<>();
        for (var s : INPUTS_CASHBACK) {
            String[] e = s.split(",");
//            tr(e);
            Info info = new Info();
            info.Date = e[0];
            info.merchant = e[1];
            info.amount = e[2];
            info.category = e[3].equals("null") ? "07" : e[3];
            Double eachTransactionCashBack = Double.parseDouble(info.amount) * categoryMap.get(info.category);
            info.cashBack = eachTransactionCashBack;
            data.add(info);
        }

        tr(data);

        Map<String, Integer> map = new HashMap<>();
        Map<String, Double> cashBackReportMap = new HashMap<>();
        for (Info info : data) {
            map.merge(info.category, Integer.parseInt(info.amount), Integer::sum);
        }
        tr(map);
        Double totalCashBack = 0.0;

        for (String category : map.keySet()) {
            int amount = map.get(category);
            double val = amount * categoryMap.get(category);
            totalCashBack += val;
            cashBackReportMap.put(category, val);
        }
        System.out.println("total cash back:" + totalCashBack);
        tr(cashBackReportMap);


    }

    static void tr(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

}
