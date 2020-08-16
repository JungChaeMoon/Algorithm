public class Main {

    static int [] coin = {500, 100, 50, 10};

    public static int solution(int money){
        int count = 0;
        for (int value : coin) {
            count += money / value;
            money = money % value;
        }

        return count;
    }

    public static void main(String[] args) {
        int money = 1260;
        System.out.println(solution(money));
    }
}

