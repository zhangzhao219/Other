import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class App {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy.MM.dd");
        SimpleDateFormat dft2 = new SimpleDateFormat("MM.dd");
        Date datebegin = dft.parse("2019.09.13");

        Date date = new Date();
        // System.out.println(dft.format(date));
        Date datenow = dft.parse(dft.format(date));

        // datenow = dft.parse("2020.09.14");

        Date nextDay = datebegin;

        int year = 0;
        int yearday = 0;
        int actualday = 0;
        while(nextDay.before(datenow)){
            Calendar cld = Calendar.getInstance();
            cld.setTime(datebegin);
            cld.add(Calendar.DATE, 1);
            datebegin = cld.getTime();
            nextDay = datebegin;
            if(dft2.format(nextDay).equals("09.13")){
                year++;
                yearday = -1;
            }
            yearday++;
            actualday++;
        }
        System.out.println("今天日期为：" + dft.format(date));
        System.out.println("相差年天数为：" + year + "年" + yearday + "天");
        System.out.println("相差天数为：" + actualday);

        
        // Calendar datenow = Calendar.getInstance();
        // int Currentyear = datenow.get(Calendar.YEAR);
        // int Currentmonth = datenow.get(Calendar.MONTH) + 1;
        // int Currentday = datenow.get(Calendar.DAY_OF_MONTH);
        // datenow.set(Currentyear, Currentmonth, Currentday);
        // long datenowm = (long)datenow.getTime().getTime();

        // Calendar datebegin = Calendar.getInstance();
        // datebegin.set(2019, 9, 13);
        // long datebeginm = (long)datebegin.getTime().getTime();
        // long actualday = (datenowm-datebeginm)/(1000*60*60*24);
        // System.out.println(actualday + "天");
        // int actualyear = 0;

        // // int tempday = 0;
        // // int temp = 0;

        // // for(int i=2020;i<=Currentyear;i++){
        // //     if(i % 4 == 0 && i % 100 != 0 || i % 400 == 0){
        // //         tempday += 366;
        // //         actualyear += 1;
        // //         temp = 366;
        // //     }
        // //     else{
        // //         tempday += 365;
        // //         actualyear += 1;
        // //         temp = 365;
        // //     }
        // // }

        // // if(tempday <= actualday){
        // //     actualday = actualday - tempday;
        // // }
        // // else{
        // //     actualday = actualday - (tempday - temp);
        // //     actualyear -= 1;
        // // }
        // // if(actualyear > 0){
        // //     if(actualday > 0){
        // //         System.out.println(actualyear + "年" + actualday + "天");
        // //     }
        // //     else{
        // //         System.out.println(actualyear + "年");
        // //     }
        // // }
        // // else{
        // //     System.out.println(actualday + "天");
        // // }

        // actualday = (datenowm-datebeginm)/1000/60/60/24;
        // System.out.println(actualday + "天");

        // String s = Currentyear + "." + Currentmonth + "." + Currentday;
        // System.out.println("2019.9.13-" + s);
    }
}
