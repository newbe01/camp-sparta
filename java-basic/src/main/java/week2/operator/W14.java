package week2.operator;

public class W14 {
    public static void main(String[] args) {
        int month = 8;
        String monthString;

        // switch
        switch (month) {
            case 1:
                monthString = "Jan";
                break;
            case 2:
                monthString = "Fab";
                 break;
            case 3:
                monthString = "Mar";
                 break;
            case 4:
                monthString = "Apr";
                 break;
            case 5:
                monthString = "Ma";
                 break;
            case 6:
                monthString = "Jun";
                 break;
            case 7:
                monthString = "Jul";
                 break;
            case 8:
                monthString = "Aug";
                 break;
            case 9:
                monthString = "Sep";
                 break;
            case 10:
                monthString = "Oct";
                 break;
            case 11:
                monthString = "Nov";
                 break;
            case 12:
                monthString = "Dec";
                 break;
            default:
                monthString = "??";
        }

        System.out.println("monthString = " + monthString);
    }
}
